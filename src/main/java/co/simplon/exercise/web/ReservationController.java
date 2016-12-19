package co.simplon.exercise.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.model.Laptop;
import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.ClassroomService;
import co.simplon.exercise.core.service.LaptopService;
import co.simplon.exercise.core.service.UserService;

import co.simplon.exercise.core.service.mailing.EmailAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.simplon.exercise.core.model.Reservation;
import co.simplon.exercise.core.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	@Autowired
	private LaptopService laptopService;

	@Autowired
	private ClassroomService classroomService;

	@Autowired
	private EmailAPI emailAPI;

	@RequestMapping
	public ModelAndView showAllReservations(ModelMap model) {
		model.addAttribute("reservations", reservationService.getAll());
		return new ModelAndView("reservation/reservations");
	}

	@RequestMapping(value = "resources/searchform", method = RequestMethod.GET)
	public ModelAndView getAvailableResourcesSearchForm(ModelMap model) {

		return new ModelAndView("reservation/search", model);

	}

	@RequestMapping(value = "resources/search")
	public ModelAndView search(
			@RequestParam(required = false, defaultValue = "0") int id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime,
			ModelMap model,
			final RedirectAttributes redirectAttribute
			)
	{
		//		if (bookingDate.isAfter(LocalDate.now()) || startTime.isBefore(endTime) || startTime.getHour()== endTime.getHour()) {
		//			redirectAttribute.addFlashAttribute("info", "L'heure de réservation ne doit pas être antérieure à la date d'aujord'hui");
		//
		//			return new ModelAndView("redirect:/reservations/resources/searchform");
		//
		//		}

		// Get the list of available items for a given date
		List<Laptop>availableLaptops   = laptopService.getAvailableLaptops(bookingDate, startTime, endTime);
		List<Classroom> availableRooms = classroomService.getAvailableRooms(bookingDate, startTime, endTime);

		if (availableLaptops.size() == 0 && availableRooms.size() == 0) {
			redirectAttribute.addFlashAttribute("info", "Aucun élémenys correspond à votre recherche !");
			return new ModelAndView("redirect:/reservations/resources/searchform", getSearchParamsMap(bookingDate, startTime, endTime));
		}
		else {
			// Get search params for booking
			Map<String, Object> searchParams = getSearchParamsMap(bookingDate, startTime, endTime);

			model.addAllAttributes(searchParams);

			model.addAttribute("availableLaptops", availableLaptops);
			model.addAttribute("availableRooms", availableRooms);
			return new ModelAndView("reservation/resource-booking");
		}
	}

	private Map<String, Object> getSearchParamsMap(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {
		Map<String, Object> searchParams = new HashMap<>();
		searchParams.put("bookingDate", bookingDate);
		searchParams.put("startTime", startTime);
		searchParams.put("endTime", endTime);
		return searchParams;
	}


	@RequestMapping(path = "/resource/add", method = RequestMethod.GET)
	public ModelAndView addOrUpdateReservation(
			@RequestParam(required = false, defaultValue = "0") int bookingId,
			@RequestParam(name = "laptopId") Integer laptopId,
			@RequestParam(name = "roomId") Integer roomId,
			@RequestParam(name = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate bookingDate,
			@RequestParam(name = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime startTime,
			@RequestParam(name = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime endTime,
			ModelMap model,
			final RedirectAttributes redirectAttribute) {
		Laptop bookedLaptop = laptopService.findById(laptopId);
		Classroom bookedRoom = classroomService.findById(roomId);

		// Get User from context
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.findOneByEmail(email);
		if (currentUser == null) {
			redirectAttribute.addFlashAttribute("", "Il faut se connecter pour pouvoir réserver");
			return new ModelAndView("redirect:/login");
		}

		// Add or update
		Date createdAt = new Date();
		Reservation res;
		if (bookingId > 0) {
			// Update if id is not null
			res = updateReservation(bookingId, bookingDate, startTime, endTime);
		} else {

			res = new Reservation(createdAt, bookingDate, startTime, endTime, currentUser,bookedLaptop, bookedRoom );
		}

		// Add the resrvation to DB
		reservationService.addOrUpdate(res);

		// Confirm booking by semding email
		sendBookingConfirmation(bookingDate, currentUser);


		// Redirection to reservations list with a flash message
		redirectAttribute.addFlashAttribute("message", "Réservation ajoutée avec succès !");
		ModelAndView mav = new ModelAndView("redirect:/reservations");
		mav.getModelMap().addAllAttributes(model);
		return mav;

	}

	private Reservation updateReservation(@RequestParam(required = false, defaultValue = "0") int bookingId, @RequestParam(name = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate, @RequestParam(name = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime, @RequestParam(name = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {
		Reservation resToUpdate = reservationService.findById(bookingId);
		resToUpdate.setBookingDate(bookingDate);
		resToUpdate.setStartTime(startTime);
		resToUpdate.setEndTime(endTime);
		return resToUpdate;
	}

	private void sendBookingConfirmation(@RequestParam(name = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate, User currentUser) {
		// Confirm booking by mail
		String to = currentUser.getEmail();
		String from = "simplon.company@gmail.com";
		String subject = "Confirmation de réservation";
		String content = " Bonjour " + currentUser.getSurname() + " vous avez éffectué une réservation pour "+bookingDate ;
		emailAPI.sendEmail(to, from, subject, content);
	}


	// Afficher le formulaire pour modifier une réservation
	@RequestMapping(path= "/updateForm")
	public ModelAndView getUpdateForm(@RequestParam Integer id, ModelMap model)
	{
		Reservation resa = reservationService.findById(id);
		model.addAttribute("reservation", resa);
		List<String> liste_start_time_selected = getSelectedList(resa.getStartTime().getHour() - 9);
		List<String> liste_end_time_selected   = getSelectedList(resa.getEndTime().getHour()  - 10);
		model.addAttribute("start_time_preselected", liste_start_time_selected);
		model.addAttribute("end_time_preselected"  , liste_end_time_selected);
		return new ModelAndView("reservation/updateReservationForm", model);
	}

	private List<String> getSelectedList(int selected)
	{
		List<String> liste_selected = new ArrayList<>();
		for(int i = 0; i < 10 ; ++i)
		{
			if( selected == i ) 
			{
				liste_selected.add("selected");	
			}
			else { liste_selected.add(""); }
		}
		return liste_selected;
	}

	@RequestMapping(path = "/delete")
	public ModelAndView  deleteReservation(@RequestParam Integer id, ModelMap model)
	{
		reservationService.delete(id);
		return new ModelAndView("redirect:/reservations");

	}

}


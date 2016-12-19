package co.simplon.exercise.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import org.springframework.ui.Model;
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

	private final DateTimeFormatter isoDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	private final DateTimeFormatter isoTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	@RequestMapping
	public ModelAndView showMyCurentReservations(ModelMap model) {
		model.addAttribute("reservations", reservationService.getMyCurentBookings(getCurrentUser().getId()));
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
			Model model,
			final RedirectAttributes redirectAttribute
			)
	{
		// Get the list of available items for a given date
		List<Laptop>availableLaptops   = laptopService.getAvailableLaptops(bookingDate, startTime, endTime);
		List<Classroom> availableRooms = classroomService.getAvailableRooms(bookingDate, startTime, endTime);

		if (availableLaptops.size() == 0 && availableRooms.size() == 0) {
			redirectAttribute.addFlashAttribute("info", "Aucun éléments correspond à votre recherche !");
			return new ModelAndView("redirect:/reservations/resources/searchform", getSearchParamsMap(bookingDate, startTime, endTime));
		}
		else {
			// Get search params for booking
			Map<String, Object> searchParams = getSearchParamsMap(bookingDate, startTime, endTime);

			model.addAllAttributes(searchParams);

			model.addAttribute("availableLaptops", availableLaptops);
			model.addAttribute("availableRooms", availableRooms);
			return new ModelAndView("reservation/resource-booking", model.asMap());
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
			@RequestParam(required = false, defaultValue = "-1") int bookingId,
			@RequestParam(name = "laptopId") Integer laptopId,
			@RequestParam(name = "roomId", required = false, defaultValue = "-1") Integer roomId,
			@RequestParam(name = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate bookingDate,
			@RequestParam(name = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime startTime,
			@RequestParam(name = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime endTime,
			Model model,
			final RedirectAttributes redirectAttribute) {
		Laptop bookedLaptop = laptopService.findById(laptopId);
		Classroom bookedRoom = classroomService.findById(roomId);

		if( bookedLaptop == null && bookedRoom == null)
		{
			// NRO : ajouter la conversion en ISO date
			model.addAttribute("bookingDate", isoDateFormatter.format(bookingDate));
			model.addAttribute("startTime",   isoTimeFormatter.format(startTime));
			model.addAttribute("endTime",     isoTimeFormatter.format(endTime));
			redirectAttribute.addFlashAttribute("msg", "Erreur : vous devez sélectionner au moins une salle ou un ordinateur");
			return new ModelAndView("redirect:/reservations/resources/search",model.asMap());
		}

		// Get User from context
		User currentUser = getCurrentUser();
		if (currentUser == null) {
			redirectAttribute.addFlashAttribute("", "Il faut se connecter pour pouvoir réserver");
			return new ModelAndView("redirect:/login");
		}

		// Add or update
		Date createdAt = new Date();
		Reservation res;
		if (bookingId >= 0) {
			// Update if id is not null
			res = updateReservation(bookingId, bookedLaptop, bookedRoom, bookingDate, startTime, endTime);
			redirectAttribute.addFlashAttribute("message", "La réservation a été modifiée avec succès !");
			if(res == null )
			{
				redirectAttribute.addFlashAttribute("msg", "Erreur : une ressource n'est pas disponible à la nouvelle date");
				model.addAttribute("id", bookingId);
				return new ModelAndView("redirect:/reservations/updateForm",model.asMap());
			}
		} else {
			res = new Reservation(createdAt, bookingDate, startTime, endTime, currentUser,bookedLaptop, bookedRoom );
		}

		// Add the reservation to DB
		reservationService.addOrUpdate(res);

		// Confirm booking by semding email
		try
		{
			sendBookingConfirmation(bookingDate, currentUser);
		}
		catch(Exception e)
		{
			System.err.println("Sending mail failed with exception : " + e);
		}

		// Redirection to reservations list with a flash message
		redirectAttribute.addFlashAttribute("message", "Réservation ajoutée avec succès !");
		return new ModelAndView("redirect:/reservations", model.asMap());

	}

	private User getCurrentUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.findOneByEmail(email);
	}

	private Reservation updateReservation(int bookingId, Laptop bookedLaptop, Classroom bookedRoom, LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
		Reservation resToUpdate = reservationService.findById(bookingId);
		resToUpdate.setBookingDate(bookingDate);
		resToUpdate.setStartTime(startTime);
		resToUpdate.setEndTime(endTime);
		resToUpdate.setLaptop(bookedLaptop);
		resToUpdate.setClassroom(bookedRoom);
		if( !reservationService.checkIsPossible(resToUpdate) )
		{
			return null;
		}
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


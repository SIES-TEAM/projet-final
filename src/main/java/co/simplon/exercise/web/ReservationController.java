package co.simplon.exercise.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.model.Laptop;
import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.LaptopService;
import co.simplon.exercise.core.service.UserService;

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
	
	@RequestMapping
	public ModelAndView showReservations(ModelMap model)
	{
		model.addAttribute("reservations", reservationService.getAll());
		
		return new ModelAndView("reservation/reservations", model);
	}
	
	/**
	 * Display the form to add a reservation
	 *
	 * @return
	 */
	@RequestMapping(value = "laptop/formAdd", method = RequestMethod.GET)
	public ModelAndView getFormAddLaptopReservation(ModelMap model) {

		return new ModelAndView("reservation/laptop-search", model);

	}

	@RequestMapping(value = "laptop/search")
	public ModelAndView searchLaptops(
						@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
						@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
						@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime,
						ModelMap model,
						final RedirectAttributes redirectAttribute
						)
	{
	    // Get the list of available items for a given date
		List<Laptop> availableLaptops = reservationService.searchAvailableLaptopsByDate(bookingDate, startTime, endTime);
		if (availableLaptops.size()==0) {
			redirectAttribute.addFlashAttribute("info", "Aucun élémenys correspond à votre recherche !");
			return new ModelAndView("redirect:/reservations/laptop/search");
		}
		else {
			// Get search params for booking
			Map<String, Object> searchParams = new HashMap<>();
			searchParams.put("bookingDate", bookingDate);
			//System.out.println(searchParams.get(bookingDate));
			searchParams.put("startTime", startTime);
			searchParams.put("endTime", endTime);
			model.addAllAttributes(searchParams);

			model.addAttribute("availableLaptops", availableLaptops);

			//Add a second lis for available rooms
//			model.addAttribute("availableRooms", availableRooms);
			return new ModelAndView("reservation/laptop-booking");
		}
	}


	@RequestMapping(path = "laptop/add", method = RequestMethod.GET)
	public ModelAndView addReservation(@RequestParam(name = "id")  Integer id,
							           @RequestParam(name = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate bookingDate,
									   @RequestParam(name = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime startTime,
									   @RequestParam(name = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime endTime,
	                                   ModelMap model,
									   final RedirectAttributes redirectAttribute)
	{
		// get Laptop objet from id
		Laptop bookedLaptop =laptopService.findById(id);
        // Get User from context
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.findOneByEmail(email);

        // Get the date of creation
		Date createdAt = new Date();
        // Create a reservation
		Reservation res = new Reservation(createdAt, bookingDate, startTime, endTime, currentUser, null, bookedLaptop );

		// Add created resrvation to DB
		reservationService.addOrUpdate(res);
		// Redirection to reservations list with a flash message
		redirectAttribute.addFlashAttribute("message", "Réservation ajoutée avec succès !");
		ModelAndView mav = new ModelAndView("redirect:/reservations");
		mav.getModelMap().addAllAttributes(model);
		return mav;

	}


	// Afficher le formulaire pour modifier une réservation
	@RequestMapping(path= "/updateForm")
	public ModelAndView updateReservation(ModelMap model)
	{
		return new ModelAndView("updateReservationForm", model);
	}
	
	@RequestMapping(path = "/delete")
	public ModelAndView  deleteReservation(@RequestParam Integer id, ModelMap model)
	{
		reservationService.delete(id);
		return new ModelAndView("redirect:/reservations");
		
	}
	
}


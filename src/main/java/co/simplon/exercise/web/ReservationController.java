package co.simplon.exercise.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	ReservationService reservationService;

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

		return new ModelAndView("reservation/laptop-reservation", model);

	}
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView showCalendar(ModelMap model) {
		return new ModelAndView("reservations/bookingCalendar", model);
	}

	
	@RequestMapping(path = "laptop/add")
	public ModelAndView addReservation(
			                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
									   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime,
			                           ModelMap model,
			                           final RedirectAttributes redirectAttribute
			                          )
	{
		List<Reservation> listLapResa = reservationService.searchAvailibilityByDate(bookingDate, startTime, endTime);

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


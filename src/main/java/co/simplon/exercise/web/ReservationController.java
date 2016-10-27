package co.simplon.exercise.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Reservation;
import co.simplon.exercise.core.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping
	public ModelAndView showReservations(ModelMap model)
	{
		model.addAttribute("reservations", reservationService.getAllReservations());
		
		return new ModelAndView("show-reservations", model);	
	}
	
	@RequestMapping(path = "/add")
	public ModelAndView addReservation(@RequestParam int userId,
			                           @RequestParam @DateTimeFormat(pattern = "ddMMyyyy")Date creationDate,
			                           @RequestParam @DateTimeFormat(pattern = "ddMMyyyy")Date dateBegin,
			                           @RequestParam @DateTimeFormat(pattern = "ddMMyyyy")Date dateEnd,
			                           ModelMap model
			                          )
	{
		reservationService.addOrUpdateReservation(new Reservation(userId, creationDate, dateBegin, dateEnd));
		return new ModelAndView("redirect:/reservations");
		
	}
}


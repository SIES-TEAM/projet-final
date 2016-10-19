package co.simplon.exercise.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}


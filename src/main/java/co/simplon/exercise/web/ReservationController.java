package co.simplon.exercise.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping
	public ModelAndView showReservations(ModelMap model)
	{
		model.addAttribute("reservations", reservationService.getAllReservations());
		
		return new ModelAndView("reservations", model);	
	}
	
	/**
	 * Display the form to add a reservation
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formAdd", method = RequestMethod.GET)
	public ModelAndView getFormAddReservation(ModelMap model) {
		
		return new ModelAndView("add-reservation", model);

	}
	
	@RequestMapping(path = "/add")
	public ModelAndView addReservation(@RequestParam int userId,
			                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateBegin,
			                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateEnd,
			                           ModelMap model,
			                           final RedirectAttributes redirectAttribute
			                          )
	{
		//if(result.hasError)
		Date creationDate = new Date();
		reservationService.addOrUpdateReservation(new Reservation(userId, creationDate, dateBegin, dateEnd));
		
		redirectAttribute.addFlashAttribute("message", "Réservation ajoutée avec succès !");
		return new ModelAndView("redirect:/reservations/formAdd");
		
	}
	
	// Modifier une réservation
	
	@RequestMapping(path= "/updateForm")
	public ModelAndView updateReservation(ModelMap model)
	{
		return new ModelAndView("updateReservationForm", model);
	}
	
	@RequestMapping(path = "/delete")
	public ModelAndView  deleteReservation(@RequestParam Integer id, ModelMap model)
	{
		reservationService.deleteReservation(id);
		return new ModelAndView("redirect:/reservations");
		
	}
	
}


package co.simplon.exercise.web;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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
		model.addAttribute("reservations", reservationService.getAll());
		
		return new ModelAndView("reservation/reservations", model);
	}
	
	/**
	 * Display the form to add a reservation
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formAdd", method = RequestMethod.GET)
	public ModelAndView getFormAddReservation(ModelMap model) {
		
		return new ModelAndView("reservation/add-reservation", model);

	}
	
	@RequestMapping(path = "/add")
	public ModelAndView addReservation(@RequestParam int userId,
			                           @RequestParam LocalDate dateBegin,
			                           @RequestParam LocalDate dateEnd,
									   @RequestParam LocalTime startTime,
									   @RequestParam LocalTime endTime,
			                           ModelMap model,
			                           final RedirectAttributes redirectAttribute
			                          )
	{
		LocalDate creationDate = new LocalDate();
		//Date trueDateDebut(dateBegin.getYear(), dateBegin.getMonth(), dateBegin.getDay(), hourBegin.getHout)
		reservationService.addOrUpdate(new Reservation(userId, creationDate, dateBegin, dateEnd, startTime, endTime));
		
		redirectAttribute.addFlashAttribute("message", "Réservation ajoutée avec succès !");
		return new ModelAndView("redirect:/reservations/formAdd");
		
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


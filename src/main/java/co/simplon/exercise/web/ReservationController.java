package co.simplon.exercise.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.model.Laptop;
import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	public ModelAndView addReservation(
			                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd,
									   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateBegin,
//									  /* @RequestParam LocalDateTime startTime,*/
//                                       @RequestParam @DateTimeFormat(pattern = "hh-") Date endTime,*/
			                           ModelMap model,
			                           final RedirectAttributes redirectAttribute
			                          )
	{
		 Date creationDate = new Date();
//		DateTime startTime = new DateTime(dateBegin.getHourOfDay(), dateBegin.getMinuteOfHour(), dateBegin.getSecondOfMinute());
//		DateTime endTime = new DateTime(dateEnd.getHourOfDay());
		Date startTime = new Date(dateBegin.getHours());
		Date endTime = new Date(dateEnd.getHours());
        User user =  userService.findById(1);
        Classroom classroom = new Classroom();
        List<Laptop> laptops = new ArrayList<>();
		reservationService.addOrUpdate(new Reservation(

                creationDate,
                dateBegin,
                dateEnd,
                startTime,
                endTime,
                user,
                classroom,
                laptops));

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


package co.simplon.exercise.web;

import co.simplon.exercise.core.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ReservationService reservationService;

    public ModelAndView dashboard(ModelMap model) {
        return new ModelAndView("admin/dashboard");
    }
    @RequestMapping(path = "/booking/historic")
    public ModelAndView showAllReservations(ModelMap model) {
        model.addAttribute("reservations", reservationService.getAll());
        return new ModelAndView("reservation/reservations");
    }
}

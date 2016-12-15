package co.simplon.exercise.web;

import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.ReservationService;
import co.simplon.exercise.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/dashboard")
    public ModelAndView dashboard(ModelMap model) {
        return new ModelAndView("admin/dashboard");
    }

    // Gestion des réservations
    @RequestMapping(path = "/bookings/historic")
    public ModelAndView showAllReservations(ModelMap model) {
        model.addAttribute("reservations", reservationService.getAll());
        return new ModelAndView("reservation/reservations");
    }

    @RequestMapping(path = "/bookings/current")
    public ModelAndView getCurrentReservations(ModelMap model) {
        model.addAttribute("reservations", reservationService.findByCurrentDate());
        return new ModelAndView("reservation/reservations");
    }

    // Gestions des utlisateurs
    @RequestMapping(path = "/users")
    public ModelAndView get(ModelMap model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return new ModelAndView("user/usersList", model);
    }

    @RequestMapping(path = "/user/form/add")
    public ModelAndView getAddUserForm() {
        return new ModelAndView("user/addUserForm");
    }

    @RequestMapping(path = "/user/add")
    public ModelAndView addUser(  @RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String role,
                                  RedirectAttributes redirectAttributes,
                                  ModelMap model) {
        userService.addOrUpdate(new User(name, surname, password, email, role));
        redirectAttributes.addFlashAttribute("message", "L'utilisteur à été ajouté avec succès !");
        return new ModelAndView("redirect:/admin/user/form/add");
    }

    // Set a simple user to admin
    @RequestMapping(path = "/user/set/admin")
    public ModelAndView setUserAsAdmin(@RequestParam Integer id) {
        User userToSet = userService.findById(id);
        userToSet.setRole("ADMIN");
        userService.addOrUpdate(userToSet);
       return new ModelAndView("/users");
    }

    // Set a message as treated
}

package co.simplon.exercise.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/authentication")
public class AuthenticationController {

//    @RequestMapping(path = "/signin")
//    public ModelAndView signin(ModelMap model) {
//        return new ModelAndView("authentication/signin");
//    }

    @RequestMapping(path = "/login")
    public ModelAndView loginForm(ModelMap model) {
        return new ModelAndView("authentication/loginForm");
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDeniedPage(ModelMap model) {

        return "authentication/accessDenied";
    }
}

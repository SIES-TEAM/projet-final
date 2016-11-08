//package co.simplon.exercise.web;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class AuthenticationController {
//
//    @RequestMapping(path = "/signin")
//    public ModelAndView signin(ModelMap model) {
//        return new ModelAndView("jsp/signin");
//    }
//
//    @RequestMapping(path = "/loginForm")
//    public ModelAndView loginForm(ModelMap model) {
//        return new ModelAndView("jsp/loginForm");
//    }
//
//    @RequestMapping(value = "/logout")
//    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return new ModelAndView("redirect:/");
//    }
//
//    @RequestMapping(value = "/accessDenied")
//    public String accessDeniedPage(ModelMap model) {
//        return "jsp/accessDenied";
//}

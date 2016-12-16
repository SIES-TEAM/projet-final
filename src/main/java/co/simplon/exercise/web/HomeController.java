package co.simplon.exercise.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model) {

		model.addAttribute("message", "Gestion de ressources Simplon");
		return new ModelAndView("home", model);

	}

}

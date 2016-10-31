package co.simplon.exercise.web;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import co.simplon.exercise.core.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private UserService userService;

	@RequestMapping()
	public ModelAndView get(ModelMap model) {
		List<User> user = userService.getAll();
		model.addAttribute("persons", user);
		return new ModelAndView("user/personsList", model);
	}
	
	@RequestMapping(path = "/addPerson")
	public ModelAndView addPerson(@RequestParam String name, @RequestParam String surname, ModelMap model) {
		userService.addOrUpdate(new User(name, surname));
		return new ModelAndView("redirect:/person");
	}
	
	@RequestMapping(path="/updatePerson")
	public ModelAndView getUpdatePersonForm(@RequestParam Integer id, ModelMap model)
	{
		User ps = userService.findById(id);
		model.addAttribute(ps);
		
		return new ModelAndView("updatePersonForm", model);		
	}
	
	@RequestMapping(path="/update")
	public ModelAndView updatePerson(Integer id, String name, String surname, ModelMap model)
	{
		User pu = userService.findById(id);
		pu.setName(name);
		pu.setSurname(surname);
		userService.addOrUpdate(pu);
		return new ModelAndView("redirect:/person", model);
		
	}

}

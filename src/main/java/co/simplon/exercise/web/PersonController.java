package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping()
	public ModelAndView get(ModelMap model) {
		List<Person> person = personService.getAll();
		model.addAttribute("persons", person);
		return new ModelAndView("person/personsList", model);
	}
	
	@RequestMapping(path = "/addPerson")
	public ModelAndView addPerson(@RequestParam String name, @RequestParam String surname, ModelMap model) {
		personService.addOrUpdate(new Person(name, surname));
		return new ModelAndView("redirect:/person");

	}
	
	@RequestMapping(path="/updatePerson")
	public ModelAndView getUpdatePersonForm(@RequestParam Integer id, ModelMap model)
	{
		Person ps = personService.findById(id);
		model.addAttribute(ps);
		
		return new ModelAndView("updatePersonForm", model);		
	}
	
	@RequestMapping(path="/update")
	public ModelAndView updatePerson(Integer id, String name, String surname, ModelMap model)
	{
		Person pu = personService.findById(id);
		pu.setName(name);
		pu.setSurname(surname);
		personService.addOrUpdate(pu);
		return new ModelAndView("redirect:/person", model);
		
	}
	
	

}

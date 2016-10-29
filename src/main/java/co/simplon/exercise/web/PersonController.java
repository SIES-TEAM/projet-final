package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.service.PersonService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping()
	public ModelAndView get(ModelMap model) {
		List<Person> person = personService.getAll();
		model.addAttribute("persons", person);
		return new ModelAndView("person", model);
	}
	
	@RequestMapping(path = "/addPerson")
	public ModelAndView addPerson(@RequestParam String name, @RequestParam String surname, ModelMap model) {
		personService.addOrUpdate(new Person(name, surname));
		return new ModelAndView("redirect:/person");
	}
	
	@RequestMapping(path="/updateForm")
	public ModelAndView getUpdatePersonForm(@RequestParam Integer id, ModelMap model)
	{
		personService.findById(id);
		return new ModelAndView("updateReservationForm");
		
	}
	
	/*@RequestMapping(path = "/addPerson", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person")Person person,
		                    BindingResult result, ModelMap model){
			if(result.hasErrors()){
				return "erreur";
			}
			model.addAttribute("name", person.getName());
			model.addAttribute("surname", person.getSurname());
		
		return "person";
	}*/

}

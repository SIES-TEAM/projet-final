package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.service.PersonService;

@RestController
@CrossOrigin
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Person> get() {
		return personService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Person post(@RequestBody Person person) {
		return personService.addOrUpdate(person);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Integer id) {
		personService.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Person update(@RequestBody Person person) {
		return personService.addOrUpdate(person);
	}

}

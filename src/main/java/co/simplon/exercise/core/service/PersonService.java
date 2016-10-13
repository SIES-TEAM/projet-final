package co.simplon.exercise.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.repository.PersonRepository;

@Repository
public class PersonService {

	@Autowired
	public PersonRepository personRepository;

	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Person addOrUpdate(Person person) {
		return personRepository.save(person);
	}

	public void delete(Integer id) {
		personRepository.delete(id);
	}

}
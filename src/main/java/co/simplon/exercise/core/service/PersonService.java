package co.simplon.exercise.core.service;

import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.repository.PersonRepository;

@Repository
public class PersonService extends GenericService< Person, PersonRepository >{

}
package co.simplon.exercise.core.service;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.repository.UserRepository;

@Repository
public class UserService extends GenericService<User, UserRepository>{

	@Autowired
	public UserRepository userRepository;
	
}
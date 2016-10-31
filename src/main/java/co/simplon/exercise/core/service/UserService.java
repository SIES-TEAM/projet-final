package co.simplon.exercise.core.service;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.repository.UserRepository;

@Repository
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User findById(Integer id) {
		return userRepository.findOne(id);
	}

	public User addOrUpdate(User user) {
		return userRepository.save(user);
	}

	public void delete(Integer id) {
		userRepository.delete(id);
	}

}
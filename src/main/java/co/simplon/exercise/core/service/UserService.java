package co.simplon.exercise.core.service;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService extends GenericService<User, UserRepository>{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addOrUpdate(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return super.addOrUpdate(user);
	}

	public void modifyUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String email, User userToUpdate) {
		userToUpdate.setName(name);
		userToUpdate.setSurname(surname);
		userToUpdate.setPassword(password);
		userToUpdate.setEmail(email);
		super.addOrUpdate(userToUpdate);
	}
	 public User findOneByEmail(String email) {

		return userRepository.findOne(email);
	 }

	 public User getCurrentUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findOne(email);
	 }
}
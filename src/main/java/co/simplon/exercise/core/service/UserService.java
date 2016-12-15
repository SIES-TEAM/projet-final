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
	 public User findOneByEmail(String email) {

		return userRepository.findOne(email);
	 }

	 public User getCurrentUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findOne(email);
	 }
}
package co.simplon.exercise.core.service;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.repository.UserRepository;

@Repository
public class UserService extends GenericService<User, UserRepository>{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User addOrUpdate(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return super.addOrUpdate(user);
	}
}
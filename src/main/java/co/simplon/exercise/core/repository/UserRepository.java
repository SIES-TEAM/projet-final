package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import co.simplon.exercise.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource
public interface UserRepository extends JpaRepository<User, Integer> {
}

package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import co.simplon.exercise.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Resource
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u where u.email = ?1")
    User findOne(String email);
}

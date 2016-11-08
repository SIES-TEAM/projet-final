package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import co.simplon.exercise.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Resource
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.name FROM User u where u.id = :id")
    User findOne(String name);
}

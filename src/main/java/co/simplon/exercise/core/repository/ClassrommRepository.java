package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Classroom;

@Resource
public interface ClassrommRepository extends JpaRepository<Classroom, Integer> {

}

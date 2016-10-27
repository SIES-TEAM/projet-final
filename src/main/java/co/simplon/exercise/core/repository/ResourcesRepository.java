package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Resources;

@Resource
public interface ResourcesRepository extends JpaRepository<Resources, Integer> {

}

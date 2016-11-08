package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Laptop;

@Resource
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	



}

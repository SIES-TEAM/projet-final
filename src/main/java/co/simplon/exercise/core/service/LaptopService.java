package co.simplon.exercise.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Laptop;

import co.simplon.exercise.core.repository.LaptopRepository;

@Repository
public class LaptopService {
	@Autowired
	public LaptopRepository laptopRepository;

	/**
	 * Lister toutes les laptops
	 * 
	 * @return
	 */
	public List<Laptop> getAllLaptops() {
		return laptopRepository.findAll();
	}
	
	
	/**
	 * Trouver un laptop à partir d'un Id
	 * 
	 * @param id
	 * @return
	 */
	public Laptop findLaptopById(Integer id) {
		return laptopRepository.findOne(id);
	}
	
	
	/**
	 * Ajouter ou modifier un laptop
	 * 
	 * @param laptop
	 * @return
	 */
	public Laptop addOrUpdateLaptop(Laptop laptop) {
		return laptopRepository.save(laptop);
	}

	/**
	 * Supprimer un laptop
	 * 
	 * @param id
	 */
	public void deleteLaptop(Integer id) {
		laptopRepository.delete(id);
	}
}

package co.simplon.exercise.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.exercise.core.model.Laptop;
import co.simplon.exercise.core.repository.LaptopRepository;

@Service
public class LaptopService extends GenericService< Laptop, LaptopRepository >{
	@Autowired
	public LaptopRepository laptopRepository;

	/**
	 * Trouver un laptop à partir d'un nom
	 * 
	 * @param id
	 * @return
	 */
	public Laptop findLaptopByName(Integer name) {
		return laptopRepository.findOne(name);
	}
	
	/**
	 * Trouver un laptop à partir d'une marque
	 */
	public Laptop findLaptopByBrand(Integer brand) {
		return laptopRepository.findOne(brand);
	}


	
}

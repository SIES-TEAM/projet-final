package co.simplon.exercise.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.exercise.core.model.Laptop;
import co.simplon.exercise.core.repository.LaptopRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class LaptopService extends GenericService< Laptop, LaptopRepository >{

    @Autowired
    private LaptopRepository laptopRepository;
    public List<Laptop> getAvailableLaptops(LocalDate resDate, LocalTime begin, LocalTime end) {
        List<Laptop> ordis = laptopRepository.findLaptopsByBookingDateAndHour(resDate, begin, end);
        return ordis;
    }
	
}

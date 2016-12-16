package co.simplon.exercise.core.service;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.model.Laptop;
import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import co.simplon.exercise.core.model.Reservation;
import co.simplon.exercise.core.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class ReservationService extends GenericService< Reservation, ReservationRepository >{

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private ReservationService reservationService;


    public List<Reservation> findByCurrentDate() {
        return reservationRepository.getAllCurentBookings();
    }


}

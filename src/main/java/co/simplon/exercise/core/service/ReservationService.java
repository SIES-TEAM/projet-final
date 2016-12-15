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

//    public List<Laptop> searchAvailableLaptopsByDate(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
//
//        List<Laptop> listBookedLaptops = reservationRepository.findLaptopsByBookingDate(bookingDate, startTime, endTime);
//        Set<Laptop> bookedLaptops = new HashSet(listBookedLaptops);
//        Set<Laptop> allLaptops = new HashSet(laptopService.getAll());
//        Set<Laptop> availableLaptops = new HashSet(allLaptops);
//        availableLaptops.removeAll(bookedLaptops);
//        return new ArrayList(availableLaptops);
//    }
//
//    public List<Classroom> searchAvailableRoomsByDate(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
//
//        List<Classroom> bookedRoomsList = reservationRepository.findRoomsByBookingDate(bookingDate, startTime, endTime);
//        Set<Laptop> bookedRooms = new HashSet(bookedRoomsList);
//        Set<Laptop> allRooms = new HashSet(laptopService.getAll());
//        Set<Laptop> availableRooms = new HashSet(allRooms);
//        availableRooms.removeAll(bookedRooms);
//        return new ArrayList(availableRooms);
//    }
    public List<Reservation> findByCurrentDate() {
        return reservationRepository.getAllCurentBookings();
    }


}

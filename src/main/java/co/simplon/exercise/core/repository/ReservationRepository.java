package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Resource
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

//    @Query("SELECT r.laptop FROM Reservation r where  r.bookingDate= :bookingDate and r.endTime = :endTime and r.startTime = :startTime")
//    List<Laptop> findLaptopsByBookingDate(@Param("bookingDate") LocalDate bookingDate,
//                                   @Param("startTime") LocalTime startTime,
//                                   @Param("endTime") LocalTime endTime);
//
//    @Query("SELECT r.classroom from Reservation r where r.bookingDate= :bookingDate and r.startTime = :startTime and r.endTime= :endTime")
//    List<Classroom> findRoomsByBookingDate(@Param("bookingDate") LocalDate bookingDate,
//                                           @Param("startTime") LocalTime startTime,
//                                           @Param("endTime") LocalTime endTime);
//
    @Query("SELECT r from Reservation r where r.bookingDate >= current_date" +
            " and r.startTime >= current_time ")
    List<Reservation> getAllCurentBookings();

//    @Query("select r from Reservation r" +
//            " where r.bookingDate between current_date and :endOfCurrentMOnth")
//    List<Reservation> getCurrentMonthBookings(@Param ("endOfCurrentMonth") LocalDate endOfCurrentMonth);
//

}

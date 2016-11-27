package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Resource
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r where  r.bookingDate= :bookingDate and r.endTime = :endTime and r.startTime = :startTime")
    List<Reservation> findByBookingDate(@Param("bookingDate") LocalDate bookingDate,
                                       @Param("startTime") LocalTime startTime,
                                       @Param("endTime") LocalTime endTime);

}

package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Laptop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Resource
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {


    @Query("SELECT l " +
            "FROM Laptop l LEFT JOIN l.reservations r " +
            "ON r.bookingDate = :bookingDate AND " +
            "r.startTime < :endTime AND :startTime < r.endTime WHERE r IS NULL" )
    List<Laptop> findLaptopsByBookingDateAndHour(@Param("bookingDate") LocalDate bookingDate,
                                                 @Param("startTime") LocalTime startTime,
                                                 @Param("endTime") LocalTime endTime);


}

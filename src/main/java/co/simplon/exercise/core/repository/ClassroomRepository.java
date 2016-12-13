package co.simplon.exercise.core.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.exercise.core.model.Classroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Resource
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    @Query("SELECT c " +
            "FROM Classroom c LEFT JOIN c.reservations r " +
            "ON r.bookingDate = :bookingDate AND " +
            "r.startTime < :endTime AND :startTime < r.endTime WHERE r IS NULL")
    List<Classroom> findAvailabeRoomsByDateAndHour(@Param("bookingDate") LocalDate bookingDate,
                                                   @Param("startTime") LocalTime startTime,
                                                   @Param("endTime") LocalTime endTime);

}

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

    @Query("SELECT r from Reservation r where r.bookingDate > current_date" +
                         " or (r.bookingDate =  current_date and r.startTime >= current_time) "+
                         " ORDER BY r.bookingDate, r.startTime ")
    List<Reservation> getAllCurentBookings();

    @Query("select r from Reservation r" +
                        " where (r.bookingDate > current_date" +
                        " OR (r.bookingDate = current_date and r.startTime >= current_time )) " +
                        " AND r.user.id = :user_id" +
                        " ORDER BY r.bookingDate, r.startTime ")
    List<Reservation> getMyCurrentBookings(@Param ("user_id") Integer user_id);

    @Query("SELECT r from Reservation r where r.bookingDate < current_date" +
                         " or (r.bookingDate =  current_date and r.startTime < current_time)" +
                         " ORDER BY r.bookingDate, r.startTime ")
    List<Reservation> getAllReservationsHistory();

    @Query("")
    List<Reservation> getMyReservationsHistory(@Param ("user_id") Integer user_id);


}

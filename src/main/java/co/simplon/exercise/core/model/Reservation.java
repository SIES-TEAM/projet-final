package co.simplon.exercise.core.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

	@Column(name = "date_of_creation", nullable = false)
	private Date creationDate;


    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name ="end_time", nullable = false)
    private LocalTime endTime;

    @ManyToOne
	private User user;

    @ManyToOne
	private Classroom classroom;

    @ManyToOne
	private Laptop laptop;

//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private List<Laptop> laptops = new ArrayList<>();

	public Reservation() {
		
	}

	public Reservation(Date creationDate, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, User user, Laptop laptop) {
		this.creationDate = creationDate;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
		this.laptop = laptop;
	}

	public Reservation(Date creationDate, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, User user, Laptop laptop, Classroom classroom) {
		this.creationDate = creationDate;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
		this.laptop = laptop;
		this.classroom = classroom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
}

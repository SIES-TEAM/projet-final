package co.simplon.exercise.core.model;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserv_id")
    private int id;

	@Column(name = "date_of_creation", nullable = false)
	private LocalDate creationDate;
  
    @Column(name = "date_begin", nullable = false)
    private LocalDate dateBegin;
    
    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name ="end_time", nullable = false)
    private LocalTime endTime;

    @ManyToOne
	@Column(name = "user_id")
	private User user;

    @OneToMany
	@Column(name = "room_id")
	private List<Classroom> classrooms = new ArrayList<>();

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Laptop> laptops = new ArrayList<>();

	public Reservation() {
		
	}

	public Reservation(LocalDate creationDate, LocalDate dateBegin, LocalDate dateEnd, LocalTime startTime, LocalTime endTime, User user, List<Classroom> classrooms, List<Laptop> laptops) {
		this.creationDate = creationDate;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
		this.classrooms = classrooms;
		this.laptops = laptops;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
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

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
}

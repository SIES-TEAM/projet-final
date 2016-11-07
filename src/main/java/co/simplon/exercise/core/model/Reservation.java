package co.simplon.exercise.core.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserv_id")
    private int id;

	@Column(name = "date_of_creation", nullable = false)
	private Date creationDate;
  
    @Column(name = "date_begin", nullable = false)
    private Date dateBegin;
    
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name ="end_time", nullable = false)
    private Date endTime;

    @ManyToOne
	@Column(name = "user_id")
	private User user;

    @OneToMany
	@Column(name = "room_id")
	private Classroom classroom;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Laptop> laptops = new ArrayList<>();

	public Reservation() {
		
	}

	public Reservation(Date creationDate, Date dateBegin, Date dateEnd, Date startTime, Date endTime, User user, Classroom classroom, List<Laptop> laptops) {
		this.creationDate = creationDate;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
		this.classroom = classroom;
		this.laptops = laptops;
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

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
}

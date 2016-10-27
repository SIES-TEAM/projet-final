package co.simplon.exercise.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserv_id")
    private int id;
	
	@Column(name = "user_id")
	private int userId; 
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ressource_id")
	private Ressource ressource; // Capacite pour une salle (null pour un ordinateur)
*/	
	/*@ManyToMany(cascade=CascadeType.ALL, mappedBy="reservations")
    private Set<CreneauHoraire> creneaux_horaires = new HashSet<CreneauHoraire>();*/
	
	@Column(name = "date_of_creation")
	private Date creationDate;
  
    @Column(name = "date_begin")
    private Date dateBegin;
    
    @Column(name = "date_end")
    private Date dateEnd;

	public Reservation() {
		
	}

	
	public Reservation(int userId, Date creationDate, Date dateBegin, Date dateEnd) {
		super();
		this.userId = userId;
		this.creationDate = creationDate;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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

}

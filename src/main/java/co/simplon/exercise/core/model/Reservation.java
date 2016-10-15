package co.simplon.exercise.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

@Entity
@Table(name = "Reservation")
public abstract class Reservation implements Serializable {

	private static final long serialVersionUID = 5798277718846300001L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserv_id")
    private int id;
	
	@Column(name = "user_id")
	private Long user_id; 
	
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
		super();
	}

	
	public Reservation(int id, Long user_id, Date creationDate, Date dateBegin, Date dateEnd) {
		super();
		this.id = id;
		this.user_id = user_id;
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


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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

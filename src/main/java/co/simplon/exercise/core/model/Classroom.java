package co.simplon.exercise.core.model;

import javax.persistence.Column;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Classroom{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int capacity;

	@OneToMany
	@JoinColumn(name = "classroom_id")
	private List<Reservation> reservations = new ArrayList<>();

	// Consturctors
	public Classroom() {
		super();
	}

	public Classroom(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}

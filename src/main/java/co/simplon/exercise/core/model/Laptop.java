package co.simplon.exercise.core.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Laptop")
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "brand")
	private String brand;

	@OneToMany
	@JoinColumn(name = "laptop_id")
	private List<Reservation> reservations = new ArrayList<>();

	// Constructors
	public Laptop() {
		super();
	}

	// Pour l'ajout d'un ordi à la base
	public Laptop(String name, String brand) {
		this.name = name;
		this.brand = brand;
	}

	public Laptop(String name, String brand, List<Reservation> reservations) {
		this.name = name;
		this.brand = brand;
		this.reservations = reservations;
	}

	// Eviter que des objets différents aient le même code
	@Override
	public int hashCode()
	{
		return 100000 + id;
	}


	@Override
	public boolean equals(Object a)
	{
		if(!Laptop.class.isInstance(a)) return false;
		return ((Laptop)a).getId() == getId();
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}

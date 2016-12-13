package co.simplon.exercise.core.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(indexes = {@Index(columnList="email,id", name="email", unique = true)})
public class User {

	public enum Role {
		USER, ADMIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	private String name;

	private String surname;

	private String password;

	@Column(unique = true)
	private String email;

	private String role;

	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Reservation> reservations = new ArrayList<>();

	public User() {
		// FOR HIBERNATE
	}

	public User(String name, String surname, String password, String email, String role) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

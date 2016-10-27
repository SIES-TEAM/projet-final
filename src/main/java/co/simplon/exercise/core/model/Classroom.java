package co.simplon.exercise.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "Classroom")
@PrimaryKeyJoinColumn(name = "resource_id")
public class Classroom extends Resources{
	
	@Column(name = "capacity")
	private int Capacity;
	
	

}

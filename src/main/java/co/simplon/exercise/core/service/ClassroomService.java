package co.simplon.exercise.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.repository.ClassroomRepository;


@Repository
public class ClassroomService {
	
	@Autowired
	public ClassroomRepository classromRepository;
	
	
	// Lister la liste des salles 
	public List<Classroom> getAllClassroom()
	{
		return classromRepository.findAll();	
	}
	
	
	/**
	 * Trouver une salle à partir d'un Id
	 */
	public Classroom findClassroomById(Integer id)
	{
		return classromRepository.findOne(id);
	}
	
	/**
	 * Ajouter ou modifier une salle

	 */
	public Classroom addOrUpdateClassroom(Classroom classroom)
	{
		return classromRepository.save(classroom);
	}
	
	/**
	 * Supprimer une salle
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		classromRepository.delete(id);
	}
	
	
	
	
	
	
	
}

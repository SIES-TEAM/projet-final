package co.simplon.exercise.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Reservation;
import co.simplon.exercise.core.repository.ReservationRepository;

@Repository
public class ReservationService {
	
	@Autowired
	public ReservationRepository reservationRepository;
	
	
	/**
	 * Lister toutes les réservation
	 * 
	 * @return
	 */
	public List<Reservation> getAllReservations()
	{
		return reservationRepository.findAll();	
	}
	
	/**
	 * Trouver une réservation à partir d'un Id
	 * 
	 * @param id
	 * @return
	 */
	public Reservation findReservationById(Integer id)
	{
		return reservationRepository.findOne(id);
	}
	
	/**
	 * Ajouter ou modifier une réservation
	 * 
	 * @param reservation
	 * @return
	 */
	public Reservation addOrUpdateReservation(Reservation reservation)
	{
		return reservationRepository.save(reservation);
	}
	
	/**
	 * Supprimer une réservation
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		reservationRepository.delete(id);
	}
}

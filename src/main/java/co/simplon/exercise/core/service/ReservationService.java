package co.simplon.exercise.core.service;

import org.springframework.stereotype.Service;

import co.simplon.exercise.core.model.Reservation;
import co.simplon.exercise.core.repository.ReservationRepository;

@Service
public class ReservationService extends GenericService< Reservation, ReservationRepository >{

}

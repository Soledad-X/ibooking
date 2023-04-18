package com.spm.ibooking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.entity.Reservation;
import com.spm.ibooking.exception.ResourceNotFoundException;
import com.spm.ibooking.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation getReservationById(Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Integer id, Reservation reservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            existingReservation.setUser(reservation.getUser());
            existingReservation.setSeat(reservation.getSeat());
            existingReservation.setStartTime(reservation.getStartTime());
            existingReservation.setEndTime(reservation.getEndTime());
            existingReservation.setStatus(reservation.getStatus());
            return reservationRepository.save(existingReservation);
        }
        throw new ResourceNotFoundException("Reservation not found with id " + id);
    }

    public void deleteReservation(Integer id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            reservationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Reservation not found with id " + id);
        }
    }
}

package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.ReservationDO;
import com.spm.ibooking.repositories.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationDO getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<ReservationDO> getAllReservations() {
        return reservationRepository.findAll();
    }

    public ReservationDO createReservation(ReservationDO reservation) {
        return reservationRepository.save(reservation);
    }

    public ReservationDO updateReservation(Integer id, ReservationDO reservation) {
        Optional<ReservationDO> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            ReservationDO existingReservation = optionalReservation.get();
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
        Optional<ReservationDO> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            reservationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Reservation not found with id " + id);
        }
    }
}

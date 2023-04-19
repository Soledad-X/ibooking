package com.spm.ibooking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.entity.Seat;
import com.spm.ibooking.exception.ResourceNotFoundException;
import com.spm.ibooking.repository.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat getSeatById(Integer id) {
        return seatRepository.findById(id).orElse(null);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Integer id, Seat seat) {
        Optional<Seat> optionalSeat = seatRepository.findById(id);
        if (optionalSeat.isPresent()) {
            Seat existingSeat = optionalSeat.get();
            existingSeat.setRoom(seat.getRoom());
            existingSeat.setHasPower(seat.getHasPower());
            existingSeat.setStatus(seat.getStatus());
            return seatRepository.save(existingSeat);
        }
        throw new ResourceNotFoundException("Seat not found with id " + id);
    }

    public void deleteSeat(Integer id) {
        Optional<Seat> optionalSeat = seatRepository.findById(id);
        if (optionalSeat.isPresent()) {
            seatRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Seat not found with id " + id);
        }
    }
}

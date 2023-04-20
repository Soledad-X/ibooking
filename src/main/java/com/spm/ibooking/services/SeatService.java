package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.SeatDO;
import com.spm.ibooking.repositories.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public SeatDO getSeatById(Integer id) {
        return seatRepository.findById(id).orElse(null);
    }

    public List<SeatDO> getAllSeats() {
        return seatRepository.findAll();
    }

    public SeatDO createSeat(SeatDO seat) {
        return seatRepository.save(seat);
    }

    public SeatDO updateSeat(Integer id, SeatDO seat) {
        Optional<SeatDO> optionalSeat = seatRepository.findById(id);
        if (optionalSeat.isPresent()) {
            SeatDO existingSeat = optionalSeat.get();
            existingSeat.setRoom(seat.getRoom());
            existingSeat.setHasPower(seat.getHasPower());
            existingSeat.setStatus(seat.getStatus());
            return seatRepository.save(existingSeat);
        }
        throw new ResourceNotFoundException("Seat not found with id " + id);
    }

    public void deleteSeat(Integer id) {
        Optional<SeatDO> optionalSeat = seatRepository.findById(id);
        if (optionalSeat.isPresent()) {
            seatRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Seat not found with id " + id);
        }
    }
}

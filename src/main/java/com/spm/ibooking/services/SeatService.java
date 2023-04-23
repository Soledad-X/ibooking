package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.RoomDto;
import com.spm.ibooking.models.dto.SeatDto;
import com.spm.ibooking.models.po.Seat;
import com.spm.ibooking.repositories.RoomRepository;
import com.spm.ibooking.repositories.SeatRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;
    
    @Autowired
    private RoomRepository roomRepository;

    public List<SeatDto> getAll() {
        return BeanUtils.convertListTo(seatRepository.findAll(), SeatDto::new, true,
            (s, t) -> t.setRoom(BeanUtils.convertTo(s.getRoom(), RoomDto::new, true)));
    }

    public SeatDto getById(Integer id) {
        return BeanUtils.convertTo(seatRepository.findById(id).orElse(null), SeatDto::new, true,
            (s, t) -> t.setRoom(BeanUtils.convertTo(s.getRoom(), RoomDto::new, true)));
    }


    public SeatDto create(SeatDto seatDto) {
        Seat seat = BeanUtils.convertTo(seatDto, Seat::new, true,
            (s, t) -> t.setRoom(roomRepository.findById(s.getRoomId()).orElse(null)));        
        System.out.println(seat.getStatus());    
        return BeanUtils.convertTo(seatRepository.save(seat), SeatDto::new, true,
            (s, t) -> t.setRoom((BeanUtils.convertTo(s.getRoom(), RoomDto::new, true))));
    }

    public SeatDto update(Integer id, SeatDto seatDto) {
        Optional<Seat> optionalSeat = seatRepository.findById(id);
        if (optionalSeat.isPresent()) {
            Seat seat = optionalSeat.get();
            BeanUtils.copyTo(seatDto, seat, true, 
                (s, t) -> t.setRoom(roomRepository.findById(s.getRoomId()).orElse(null)));
            return BeanUtils.convertTo(seatRepository.save(seat), SeatDto::new, true,
                (s, t) -> t.setRoom(BeanUtils.convertTo(s.getRoom(), RoomDto::new, true)));
        }
        throw new ResourceNotFoundException("Seat not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<Seat> optionalSeat = seatRepository.findById(id);
        if (optionalSeat.isPresent()) {
            seatRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Seat not found with id " + id);
        }
    }
}

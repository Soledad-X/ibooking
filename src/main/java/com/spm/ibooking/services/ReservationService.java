package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.ReservationDto;
import com.spm.ibooking.models.dto.SeatDto;
import com.spm.ibooking.models.dto.UserDto;
import com.spm.ibooking.models.po.Reservation;
import com.spm.ibooking.repositories.ReservationRepository;
import com.spm.ibooking.repositories.SeatRepository;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    public List<ReservationDto> getAll() {
        return BeanUtils.convertListTo(reservationRepository.findAll(), ReservationDto::new, true,
            (s, t) -> {
                t.setUser(BeanUtils.convertTo(s.getUser(), UserDto::new, true));
                t.setSeat(BeanUtils.convertTo(s.getSeat(), SeatDto::new, true));
            });
    }

    public ReservationDto getById(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        System.out.println(reservation.getSeat().getRoom().getName());
        return BeanUtils.convertTo(reservation, ReservationDto::new, true,
            (s, t) -> {
                t.setUser(BeanUtils.convertTo(s.getUser(), UserDto::new, true));
                t.setSeat(BeanUtils.convertTo(s.getSeat(), SeatDto::new, true));
            });
    }

    public ReservationDto create(ReservationDto reservationDto) {
        Reservation reservation = BeanUtils.convertTo(reservationDto, Reservation::new, true,
            (s, t) -> {
                t.setUser(userRepository.findById(reservationDto.getUserId()).orElse(null));
                t.setSeat(seatRepository.findById(reservationDto.getSeatId()).orElse(null));
            });
        return BeanUtils.convertTo(reservationRepository.save(reservation), ReservationDto::new, true,
            (s, t) -> {
                t.setUser(BeanUtils.convertTo(s.getUser(), UserDto::new, true));
                t.setSeat(BeanUtils.convertTo(s.getSeat(), SeatDto::new, true));
            });
    }

    public ReservationDto update(Integer id, ReservationDto reservationDto) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            BeanUtils.copyTo(reservationDto, reservation, true, 
                (s, t) -> {

                });
            return BeanUtils.convertTo(reservationRepository.save(reservation), ReservationDto::new, true,
                (s, t) -> {
              
                });
        }
        throw new ResourceNotFoundException("ReservationDto not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<Reservation> optionalReservation= reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            reservationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("ReservationDto not found with id " + id);
        }
    }
}

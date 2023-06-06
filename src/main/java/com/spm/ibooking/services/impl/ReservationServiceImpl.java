package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Reservation;
import com.spm.ibooking.models.entity.SignIn;
import com.spm.ibooking.models.enums.ReservationStatus;
import com.spm.ibooking.models.enums.SignInStatus;
import com.spm.ibooking.models.vo.ReservationVO;
import com.spm.ibooking.repositories.ReservationRepository;
import com.spm.ibooking.repositories.SeatRepository;
import com.spm.ibooking.repositories.UserRepository;
import com.spm.ibooking.services.ReservationService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(reservationRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findById(id).orElse(null));
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(ReservationVO reservationVO) {

        Reservation reservation = new Reservation();
        UpdateUtil.copyNullProperties(reservationVO, reservation);
        if (reservationVO.getUserId() != null)
            if (userRepository.existsById(reservationVO.getUserId()))
                reservation.setUser(userRepository.findById(reservationVO.getUserId()).get());
            else return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The specified user_id does not exist.");
        if (reservationVO.getSeatId() != null)
            if (seatRepository.existsById(reservationVO.getSeatId()))
                reservation.setSeat(seatRepository.findById(reservationVO.getSeatId()).get());
            else return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The specified seat_id does not exist.");

        SignIn signIn = new SignIn();
        signIn.setReservation(reservation);
        signIn.setStartTime(reservation.getStartTime());
        signIn.setStatus(SignInStatus.PENDING);
        reservation.setStatus(ReservationStatus.PENDING);
        reservation.setSignIn(signIn);
        reservationRepository.save(reservation);
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservation);
    }

    @Override
    public String update(Integer id, ReservationVO reservationVO) {

        if(reservationRepository.existsById(id)) {
            Reservation reservation = reservationRepository.findById(id).get();
            UpdateUtil.copyNullProperties(reservationVO, reservation);
            if (reservationVO.getUserId() != null)
                if (userRepository.existsById(reservationVO.getUserId()))
                    reservation.setUser(userRepository.findById(reservationVO.getUserId()).get());
                else return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The specified user_id does not exist.");
            
            if (reservationVO.getSeatId() != null)
                if (seatRepository.existsById(reservationVO.getSeatId()))
                    reservation.setSeat(seatRepository.findById(reservationVO.getSeatId()).get());
                else return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The specified seat_id does not exist.");

            reservationRepository.save(reservation);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservation);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {
        
        if(reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getUserById(Integer id) {

        if(reservationRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findById(id).get().getUser());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getSeatById(Integer id) {

        if(reservationRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findById(id).get().getSeat());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getSignInById(Integer id) {

        if(reservationRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findById(id).get().getSignIn());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

}

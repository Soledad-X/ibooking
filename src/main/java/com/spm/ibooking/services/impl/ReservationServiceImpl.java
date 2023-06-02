package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Reservation;
import com.spm.ibooking.models.vo.ReservationVO;
import com.spm.ibooking.repositories.ReservationRepository;
import com.spm.ibooking.services.ReservationService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(reservationRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservationRepository.findById(id));
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(ReservationVO reservationVO) {

        Reservation reservation = new Reservation();
        UpdateUtil.copyNullProperties(reservationVO, reservation);
        reservationRepository.save(reservation);
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, reservation);
    }

    @Override
    public String update(Integer id, ReservationVO reservationVO) {

        if(reservationRepository.existsById(id)) {
            Reservation reservation = reservationRepository.findById(id).get();
            UpdateUtil.copyNullProperties(reservationVO, reservation);
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

}

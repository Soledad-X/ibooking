package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Seat;
import com.spm.ibooking.models.vo.SeatVO;
import com.spm.ibooking.repositories.SeatRepository;
import com.spm.ibooking.services.SeatService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class SeatServiceImpl implements SeatService{

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, seatRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(seatRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, seatRepository.findById(id));
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(SeatVO seatVO) {

        Seat seat = new Seat();
        UpdateUtil.copyNullProperties(seatVO, seat);
        seatRepository.save(seat);
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, seat);
    }

    @Override
    public String update(Integer id, SeatVO seatVO) {

        if(seatRepository.existsById(id)) {
            Seat seat = seatRepository.findById(id).get();
            UpdateUtil.copyNullProperties(seatVO, seat);
            seatRepository.save(seat);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, seat);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {
        
        if(seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

}

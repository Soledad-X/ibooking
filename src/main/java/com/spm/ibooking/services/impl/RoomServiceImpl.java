package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Room;
import com.spm.ibooking.models.vo.RoomVO;
import com.spm.ibooking.repositories.RoomRepository;
import com.spm.ibooking.services.RoomService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, roomRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(roomRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, roomRepository.findById(id).get());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(RoomVO roomVO) {

        if(!roomRepository.existsByName(roomVO.getName())) {
            Room room = new Room();
            UpdateUtil.copyNullProperties(roomVO, room);
            roomRepository.save(room);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, room);
        }
        else return ResponseUtil.response(ResponseStatus.DUPLICATE_NAME);
    }

    @Override
    public String update(Integer id, RoomVO roomVO) {

        if(roomRepository.existsById(id)) {
            Room room = roomRepository.findById(id).get();
            UpdateUtil.copyNullProperties(roomVO, room);
            roomRepository.save(room);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, room);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {

        if(roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getBuildingById(Integer id) {
        
        if(roomRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, roomRepository.findById(id).get().getBuilding());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getSeatsById(Integer id) {
        
        if(roomRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, roomRepository.findById(id).get().getSeats());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }


    @Override
    public String getBuildingByName(String name) {
        
        if(roomRepository.existsByName(name)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, roomRepository.findByName(name).get().getBuilding());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getSeatsByName(String name) {
        
        if(roomRepository.existsByName(name)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, roomRepository.findByName(name).get().getSeats());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

}


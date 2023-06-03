package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Building;
import com.spm.ibooking.models.vo.BuildingVO;
import com.spm.ibooking.repositories.BuildingRepository;
import com.spm.ibooking.services.BuildingService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, buildingRepository.findAll());
    }

    @Override
    public String getById(Integer id) {

        if(buildingRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, buildingRepository.findById(id).get());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(BuildingVO buildingVO) {

        if(!buildingRepository.existsByName(buildingVO.getName())) {
            Building building = new Building();
            UpdateUtil.copyNullProperties(buildingVO, building);
            buildingRepository.save(building);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, building);
        }
        else return ResponseUtil.response(ResponseStatus.DUPLICATE_NAME);
    }

    @Override
    public String update(Integer id, BuildingVO buildingVO) {

        if(buildingRepository.existsById(id)) {
            Building building = buildingRepository.findById(id).get();
            UpdateUtil.copyNullProperties(buildingVO, building);
            buildingRepository.save(building);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, building);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {

        if(buildingRepository.existsById(id)) {
            buildingRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }
    
    @Override
    public String getRoomsByName(String name) {
        
        if(buildingRepository.existsByName(name)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, buildingRepository.findByName(name).get().getRooms());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getRoomsById(Integer id) {
        
        if(buildingRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, buildingRepository.findById(id).get().getRooms());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getCampusById(Integer id) {
        
        if(buildingRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, buildingRepository.findById(id).get().getCampus());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String getCampusByName(String name) {
        
        if(buildingRepository.existsByName(name)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, buildingRepository.findByName(name).get().getCampus());
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }
}

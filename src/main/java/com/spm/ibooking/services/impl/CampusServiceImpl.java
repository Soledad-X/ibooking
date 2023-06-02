package com.spm.ibooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Campus;
import com.spm.ibooking.models.vo.CampusVO;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.services.CampusService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class CampusServiceImpl implements CampusService {

    @Autowired
    private CampusRepository campusRepository;

    @Override
    public String getAll() {

        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, campusRepository.findAll());
    }

    @Override
    public String getById(Integer id) {
        
        if(campusRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, campusRepository.findById(id));
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(CampusVO campusVO) {

        if(!campusRepository.existsByName(campusVO.getName())) {
            Campus campus = new Campus();
            UpdateUtil.copyNullProperties(campusVO, campus);
            campusRepository.save(campus);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, campus);
        }
        else return ResponseUtil.response(ResponseStatus.DUPLICATE_NAME);
    }

    @Override
    public String update(Integer id, CampusVO campusVO) {

        if(campusRepository.existsById(id)) {
            Campus campus = campusRepository.findById(id).get();
            UpdateUtil.copyNullProperties(campusVO, campus);
            campusRepository.save(campus);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, campus);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {
        
        if(campusRepository.existsById(id)) {
            campusRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

}


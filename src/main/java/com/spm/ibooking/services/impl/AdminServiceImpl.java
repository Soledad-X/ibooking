package com.spm.ibooking.services.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.ibooking.models.entity.Admin;
import com.spm.ibooking.models.vo.AdminVO;
import com.spm.ibooking.repositories.AdminRepository;
import com.spm.ibooking.services.AdminService;
import com.spm.ibooking.utils.ResponseStatus;
import com.spm.ibooking.utils.ResponseUtil;
import com.spm.ibooking.utils.UpdateUtil;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    
    @Override
    public String getAll() {
        return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, adminRepository.findAll());
    }

    @Override
    public String getById(Integer id) {
        
        if(adminRepository.existsById(id)) {
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, adminRepository.findById(id));
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String create(AdminVO adminVO) {
        
        Admin admin = adminRepository.findByUsernameOrEmailOrPhone(adminVO.getUsername(), adminVO.getEmail(), adminVO.getPhone()).orElse(null);
        if(admin == null) {
            admin = new Admin();
            BeanUtils.copyProperties(adminVO, admin);
            adminRepository.save(admin);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, admin);
        } else {
            if(adminVO.getUsername().equals(admin.getUsername()))
                return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The username already exists.");
            else if(adminVO.getEmail().equals(admin.getEmail()))
                return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The email already exists.");
            else
                return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The phone already exists.");
        }
    }

    @Override
    public String update(Integer id, AdminVO adminVO) {
        
        if(adminRepository.existsById(id)) {
            Admin admin = adminRepository.findById(id).get();
            UpdateUtil.copyNullProperties(adminVO, admin);
            adminRepository.save(admin);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, admin);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String delete(Integer id) {
        
        if(adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return ResponseUtil.response(ResponseStatus.SUCCESS);
        }
        else return ResponseUtil.response(ResponseStatus.ENTITY_NOT_FOUND);
    }

    @Override
    public String validate(AdminVO adminVO) {
        Admin admin = adminRepository.findByUsernameOrEmailOrPhone(adminVO.getUsername(), adminVO.getEmail(), adminVO.getPhone()).orElse(null);
        if (admin == null) {
            return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "The username does not exist.");
        } else if (!admin.getPassword().equals(adminVO.getPassword())) {
            return ResponseUtil.response(ResponseStatus.FAILED.getCode(), "Account or password error.");
        } else {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            admin.setPassword(null); // 过滤
            BeanUtils.copyProperties(admin, adminVO);
            return ResponseUtil.responseWithData(ResponseStatus.SUCCESS, token);
        }
    }

}


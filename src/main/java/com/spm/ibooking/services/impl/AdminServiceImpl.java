package com.spm.ibooking.services.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.models.entity.Admin;
import com.spm.ibooking.models.vo.AdminVO;
import com.spm.ibooking.repositories.AdminRepository;
import com.spm.ibooking.services.AdminService;
import com.spm.ibooking.utils.ResultUtil;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    
    @Override
    public String getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public String getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String create(AdminVO adminVO) {
        
        Admin admin = adminRepository.findByUsernameOrEmailOrPhone(adminVO.getUsername(), adminVO.getEmail(), adminVO.getPhone()).orElse(null);
        if(admin == null) {
            admin = new Admin();
            BeanUtils.copyProperties(adminVO, admin);
            adminRepository.save(admin);
            adminVO.setPassword(null);
            return ResultUtil.successWithData(adminVO);
        } else {
            if(adminVO.getUsername().equals(admin.getUsername()))
                return ResultUtil.errorWithMessage("username 已存在");
            else if(adminVO.getEmail().equals(admin.getEmail()))
                return ResultUtil.errorWithMessage("email 已存在");
            else
                return ResultUtil.errorWithMessage("phone 已存在");
        }
    }

    @Override
    public String update(Integer id, AdminVO adminVO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String validate(AdminVO adminVO) {
        Admin admin = adminRepository.findByUsernameOrEmailOrPhone(adminVO.getUsername(), adminVO.getEmail(), adminVO.getPhone()).orElse(null);
        if (admin == null) {
            return ResultUtil.errorWithMessage("用户不存在");
        } else if (!admin.getPassword().equals(adminVO.getPassword())) {
            return ResultUtil.errorWithMessage("账户或密码错误");
        } else {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            admin.setPassword(null); // 过滤
            BeanUtils.copyProperties(admin, adminVO);
            return ResultUtil.successWithDataAndMessage(adminVO, token);
        }
    }

}


package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.AdminBo;
import com.spm.ibooking.models.dto.AdminDto;
import com.spm.ibooking.models.po.Admin;
import com.spm.ibooking.repositories.AdminRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminBo> getAllAdmins() {
        return BeanUtils.convertListTo(adminRepository.findAll(), AdminBo::new, true);
    }

    public AdminBo getAdminById(Integer id) {
        return BeanUtils.convertTo(adminRepository.findById(id).orElse(null), AdminBo::new, true);
    }

    public AdminBo createAdmin(AdminDto adminDto) {
        Admin admin = BeanUtils.convertTo(adminDto, Admin::new, true);
        return BeanUtils.convertTo(admin, AdminBo::new, true);
    }

    public AdminBo updateAdmin(Integer id, AdminDto adminDto) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setUsername(adminDto.getUsername());
            admin.setPassword(adminDto.getPassword());
            admin.setEmail(adminDto.getEmail());
            admin.setPhone(adminDto.getPhone());
            return BeanUtils.convertTo(adminRepository.save(admin), AdminBo::new, true);
        }
        throw new ResourceNotFoundException("Admin not found with id " + id);
    }

    public void deleteAdmin(Integer id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            adminRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Admin not found with id " + id);
        }
    }
}


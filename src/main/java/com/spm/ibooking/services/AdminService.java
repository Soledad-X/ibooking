package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.AdminBO;
import com.spm.ibooking.models.DTO.AdminDTO;
import com.spm.ibooking.models.PO.Admin;
import com.spm.ibooking.repositories.AdminRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminBO> getAllAdmins() {
        return BeanUtils.convertListTo(adminRepository.findAll(), AdminBO::new, true);
    }

    public AdminBO getAdminById(Integer id) {
        return BeanUtils.convertTo(adminRepository.findById(id).orElse(null), AdminBO::new, true);
    }

    public AdminBO createAdmin(AdminDTO adminDTO) {
        Admin admin = BeanUtils.convertTo(adminDTO, Admin::new, true);
        return BeanUtils.convertTo(admin, AdminBO::new, true);
    }

    public AdminBO updateAdmin(Integer id, AdminDTO adminDTO) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setUsername(adminDTO.getUsername());
            admin.setPassword(adminDTO.getPassword());
            admin.setEmail(adminDTO.getEmail());
            admin.setPhone(adminDTO.getPhone());
            return BeanUtils.convertTo(adminRepository.save(admin), AdminBO::new, true);
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


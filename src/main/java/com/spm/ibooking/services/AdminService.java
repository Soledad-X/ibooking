package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.dto.AdminDto;
import com.spm.ibooking.models.po.Admin;
import com.spm.ibooking.repositories.AdminRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDto> getAll() {
        return BeanUtils.convertListTo(adminRepository.findAll(), AdminDto::new, true);
    }

    public AdminDto getById(Integer id) {
        return BeanUtils.convertTo(adminRepository.findById(id).orElse(null), AdminDto::new, true);
    }

    public AdminDto create(AdminDto adminDto) {
        Admin admin = BeanUtils.convertTo(adminDto, Admin::new, true);
        return BeanUtils.convertTo(adminRepository.save(admin), AdminDto::new, true);
    }

    public AdminDto update(Integer id, AdminDto adminDto) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            BeanUtils.copyTo(adminDto, admin, true);
            return BeanUtils.convertTo(adminRepository.save(admin), AdminDto::new, true);
        }
        throw new ResourceNotFoundException("Admin not found with id " + id);
    }

    public void delete(Integer id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            adminRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Admin not found with id " + id);
        }
    }
}


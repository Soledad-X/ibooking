package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.AdminDO;
import com.spm.ibooking.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDO> getAllAdmins() {
        return adminRepository.findAll();
    }

    public AdminDO getAdminById(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    public AdminDO createAdmin(AdminDO admin) {
        return adminRepository.save(admin);
    }

    public AdminDO updateAdmin(Integer id, AdminDO admin) {
        Optional<AdminDO> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            AdminDO existingAdmin = optionalAdmin.get();
            existingAdmin.setUsername(admin.getUsername());
            existingAdmin.setPassword(admin.getPassword());
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setPhone(admin.getPhone());
            return adminRepository.save(existingAdmin);
        }
        throw new ResourceNotFoundException("Admin not found with id " + id);
    }

    public void deleteAdmin(Integer id) {
        Optional<AdminDO> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            adminRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Admin not found with id " + id);
        }
    }
}


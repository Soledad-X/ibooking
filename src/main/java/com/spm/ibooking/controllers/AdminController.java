package com.spm.ibooking.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.AdminBO;
import com.spm.ibooking.models.DTO.AdminDTO;
import com.spm.ibooking.services.AdminService;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminBO> getAdminById(@PathVariable Integer id) throws ResourceNotFoundException {
        AdminBO adminBO = adminService.getAdminById(id);
        return ResponseEntity.ok(adminBO);
    }

    @PostMapping
    public ResponseEntity<AdminBO> createAdmin(@RequestBody AdminDTO adminDTO) {
        AdminBO createdAdmin = adminService.createAdmin(adminDTO);
        return ResponseEntity.created(URI.create("/api/admins/" + createdAdmin.getId())).body(createdAdmin);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdminBO> updateAdmin(@PathVariable Integer id, @RequestBody AdminDTO adminDTO) throws ResourceNotFoundException {
        AdminBO updateAdmin = adminService.updateAdmin(id, adminDTO);
        return ResponseEntity.ok(updateAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) throws ResourceNotFoundException {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdminBO>> getAllAdmins() {
        List<AdminBO> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
}


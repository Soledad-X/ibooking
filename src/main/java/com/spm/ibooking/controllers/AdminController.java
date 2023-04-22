package com.spm.ibooking.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.AdminBo;
import com.spm.ibooking.models.dto.AdminDto;
import com.spm.ibooking.services.AdminService;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminBo> getAdminById(@PathVariable Integer id) throws ResourceNotFoundException {
        AdminBo adminBO = adminService.getAdminById(id);
        return ResponseEntity.ok(adminBO);
    }

    @PostMapping
    public ResponseEntity<AdminBo> createAdmin(@RequestBody AdminDto adminDto) {
        AdminBo createdAdmin = adminService.createAdmin(adminDto);
        return ResponseEntity.created(URI.create("/api/admins/" + createdAdmin.getId())).body(createdAdmin);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdminBo> updateAdmin(@PathVariable Integer id, @RequestBody AdminDto adminDto) throws ResourceNotFoundException {
        AdminBo updateAdmin = adminService.updateAdmin(id, adminDto);
        return ResponseEntity.ok(updateAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) throws ResourceNotFoundException {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdminBo>> getAllAdmins() {
        List<AdminBo> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
}


package com.spm.ibooking.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.AdminDO;
import com.spm.ibooking.services.AdminService;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminDO> getAdminById(@PathVariable Integer id) throws ResourceNotFoundException {
        AdminDO admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PostMapping
    public ResponseEntity<AdminDO> createAdmin(@RequestBody AdminDO admin) {
        AdminDO createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.created(URI.create("/api/admins/" + createdAdmin.getId())).body(createdAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDO> updateAdmin(@PathVariable Integer id, @RequestBody AdminDO admin) throws ResourceNotFoundException {
        AdminDO updatedAdmin = adminService.updateAdmin(id, admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) throws ResourceNotFoundException {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdminDO>> getAllAdmins() {
        List<AdminDO> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
}


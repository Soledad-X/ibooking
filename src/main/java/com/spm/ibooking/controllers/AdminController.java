package com.spm.ibooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.ibooking.models.vo.AdminVO;
import com.spm.ibooking.services.AdminService;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getAll() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return adminService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody AdminVO adminVO) {
        return adminService.create(adminVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody AdminVO adminVO) {
        return adminService.update(id, adminVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return adminService.delete(id);
    }
}


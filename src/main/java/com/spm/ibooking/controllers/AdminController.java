package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.spm.ibooking.models.dto.AdminDto;
import com.spm.ibooking.services.AdminService;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AdminDto> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AdminDto getById(@PathVariable Integer id) {
        return adminService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AdminDto create(@RequestBody AdminDto adminDto) {
        return adminService.create(adminDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AdminDto update(@PathVariable Integer id, @RequestBody AdminDto adminDto) {
        return adminService.update(id, adminDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public Void delete(@PathVariable Integer id) {
        adminService.delete(id);
        return null;
    }

}


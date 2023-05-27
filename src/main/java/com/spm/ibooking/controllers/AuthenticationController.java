package com.spm.ibooking.controllers;

import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spm.ibooking.models.dto.AdminDto;
import com.spm.ibooking.models.dto.UserDto;
import com.spm.ibooking.services.AdminService;
import com.spm.ibooking.services.UserService;

@RestController
@RequestMapping(value = "/api")
public class AuthenticationController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ResponseStatus(value =  HttpStatus.CREATED)
    @ResponseBody
    public UserDto login(@RequestBody UserDto userDto) {
        return userService.validate(userDto);
    }

    @PostMapping("/admin_login")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AdminDto adminLogin(@RequestBody AdminDto adminDto) {
        return adminService.validate(adminDto);
    }

    @PostMapping("/register")
    @ResponseStatus(value =  HttpStatus.CREATED)
    @ResponseBody
    public UserDto register(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }
}

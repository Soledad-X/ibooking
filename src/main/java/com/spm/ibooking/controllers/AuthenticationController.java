package com.spm.ibooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spm.ibooking.models.vo.AdminVO;
import com.spm.ibooking.models.vo.UserVO;
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
    public String login(@RequestBody UserVO userVO) {
        return userService.validate(userVO);
    }

    @PostMapping("/admin_login")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String adminLogin(@RequestBody AdminVO adminVO) {
        return adminService.validate(adminVO);
    }

    @PostMapping("/register")
    @ResponseStatus(value =  HttpStatus.CREATED)
    @ResponseBody
    public String register(@RequestBody UserVO userVO) {
        return userService.create(userVO);
    }
}

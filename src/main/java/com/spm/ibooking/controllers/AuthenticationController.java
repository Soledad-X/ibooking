package com.spm.ibooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.ibooking.models.vo.AdminVO;
import com.spm.ibooking.models.vo.UserVO;
import com.spm.ibooking.services.AdminService;
import com.spm.ibooking.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "api/auth")
@Api(value = "Auth", tags = {"Authentication"})
public class AuthenticationController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation(value = "获取管理员列表", notes = "获取管理员列表")
    public String login(@RequestBody UserVO userVO) {
        return userService.validate(userVO);
    }

    @PostMapping("/admin_login")
    public String adminLogin(@RequestBody AdminVO adminVO) {
        return adminService.validate(adminVO);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserVO userVO) {
        return userService.create(userVO);
    }

    @PostMapping("/logout")
    public String logout() {
        
        return "";
    }
}

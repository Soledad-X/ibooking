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

import com.spm.ibooking.models.vo.UserVO;
import com.spm.ibooking.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody UserVO userVO) {
        return userService.create(userVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody UserVO userVO) {
        return userService.update(id, userVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

}


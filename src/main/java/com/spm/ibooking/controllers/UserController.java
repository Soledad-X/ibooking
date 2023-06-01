package com.spm.ibooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        userService.delete(id);
        return null;
    }

}


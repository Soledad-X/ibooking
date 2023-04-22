package com.spm.ibooking.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.UserBo;
import com.spm.ibooking.models.dto.UserDto;
import com.spm.ibooking.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserBo>> getAllUsers() {
        List<UserBo> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBo> getUserById(@PathVariable Integer id) throws ResourceNotFoundException {
        UserBo user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserBo> createUser(@RequestBody UserDto userDto) {
        UserBo createdUser = userService.createUser(userDto);
        return ResponseEntity.created(URI.create("/api/users/" + createdUser.getId())).body(createdUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserBo> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) throws ResourceNotFoundException {
        UserBo updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) throws ResourceNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}


package com.spm.ibooking.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.UserBO;
import com.spm.ibooking.models.DTO.UserDTO;
import com.spm.ibooking.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserBO>> getAllUsers() {
        List<UserBO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBO> getUserById(@PathVariable Integer id) throws ResourceNotFoundException {
        UserBO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserBO> createUser(@RequestBody UserDTO userDTO) {
        UserBO createdUser = userService.createUser(userDTO);
        return ResponseEntity.created(URI.create("/api/users/" + createdUser.getId())).body(createdUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserBO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) throws ResourceNotFoundException {
        UserBO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) throws ResourceNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}


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

import com.spm.ibooking.models.vo.SignInVO;
import com.spm.ibooking.services.SignInService;

@RestController
@RequestMapping(value = "/api/signIns")
public class SignInController {
    
    @Autowired
    private SignInService signInService;

    @GetMapping
    public String getAll() {
        return signInService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return signInService.getById(id);
    }

    @GetMapping("/{id}/reservation")
    public String getReservationById(@PathVariable Integer id) {
        return signInService.getReservationById(id);
    }

    @PostMapping
    public String create(@RequestBody SignInVO signInVO) {
        return signInService.create(signInVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody SignInVO signInVO) {
        return signInService.update(id, signInVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return signInService.delete(id);
    }
}

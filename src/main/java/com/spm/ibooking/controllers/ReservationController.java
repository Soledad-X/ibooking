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

import com.spm.ibooking.models.vo.ReservationVO;
import com.spm.ibooking.services.ReservationService;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return reservationService.getById(id);
    }

    @GetMapping("/{id}/user")
    public String getUserById(@PathVariable Integer id) {
        return reservationService.getUserById(id);
    }

    @GetMapping("/{id}/seat")
    public String getSeatById(@PathVariable Integer id) {
        return reservationService.getSeatById(id);
    }

    @GetMapping("/{id}/signIn")
    public String getSignInById(@PathVariable Integer id) {
        return reservationService.getSignInById(id);
    }

    @PostMapping
    public String create(@RequestBody ReservationVO reservationVO) {
        return reservationService.create(reservationVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody ReservationVO reservationVO) {
        return reservationService.update(id, reservationVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return reservationService.delete(id);
    }

}


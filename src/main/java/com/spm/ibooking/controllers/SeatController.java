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

import com.spm.ibooking.models.vo.SeatVO;
import com.spm.ibooking.services.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    
    @Autowired
    private SeatService seatService;

    @GetMapping
    public String getAll() {
        return seatService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return seatService.getById(id);
    }

    @GetMapping("/{id}/room")
    public String getRoomById(@PathVariable Integer id) {
        return seatService.getRoomById(id);
    }

    @GetMapping("/{id}/reservations")
    public String getReservationsById(@PathVariable Integer id) {
        return seatService.getReservationsById(id);
    }

    @PostMapping
    public String create(@RequestBody SeatVO seatVO) {
        return seatService.create(seatVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody SeatVO seatVO) {
        return seatService.update(id, seatVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return seatService.delete(id);
    }
}

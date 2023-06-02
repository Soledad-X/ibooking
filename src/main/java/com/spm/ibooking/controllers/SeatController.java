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

    // @GetMapping("/")
    // @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    // public List<SeatVO> getByRoomId(@RequestParam(value = "roomId", required = false) Integer roomId) {
    //     return seatService.getByRoomId(roomId);
    // }

    @GetMapping("/{seatId}")
    public String getById(@PathVariable Integer seatId) {
        return seatService.getById(seatId);
    }

    @PostMapping
    public String create(@RequestBody SeatVO seatVO) {
        return seatService.create(seatVO);
    }

    @PatchMapping("/{seatId}")
    public String update(@PathVariable Integer seatId, @RequestBody SeatVO seatVO) {
        return seatService.update(seatId, seatVO);
    }

    @DeleteMapping("/{seatId}")
    public String delete(@PathVariable Integer seatId) {
        return seatService.delete(seatId);
    }
}

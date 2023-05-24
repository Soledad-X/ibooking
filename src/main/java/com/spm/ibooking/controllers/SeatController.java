package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.models.dto.SeatDto;
import com.spm.ibooking.services.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    
    @Autowired
    private SeatService seatService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SeatDto> getAll() {
        return seatService.getAll();
    }

    // @GetMapping("/")
    // @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    // public List<SeatDto> getByRoomId(@RequestParam(value = "roomId", required = false) Integer roomId) {
    //     return seatService.getByRoomId(roomId);
    // }

    @GetMapping("/{seatId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SeatDto getById(@PathVariable Integer seatId) {
        return seatService.getById(seatId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SeatDto create(@RequestBody SeatDto seatDto) {
        return seatService.create(seatDto);
    }

    @PatchMapping("/{seatId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SeatDto update(@PathVariable Integer seatId, @RequestBody SeatDto seatDto) {
        return seatService.update(seatId, seatDto);
    }

    @DeleteMapping("/{seatId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public Void delete(@PathVariable Integer seatId) {
        seatService.delete(seatId);
        return null;
    }
}

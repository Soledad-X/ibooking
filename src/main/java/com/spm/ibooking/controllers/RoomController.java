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

import com.spm.ibooking.models.vo.RoomVO;
import com.spm.ibooking.services.RoomService;

@RestController
@RequestMapping(value = "/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public String getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return roomService.getById(id);
    }

    @GetMapping("/{id}/building")
    public String getBuildingById(@PathVariable Integer id) {
        return roomService.getBuildingById(id);
    }

    @GetMapping("/{id}/seats")
    public String getSeatsById(@PathVariable Integer id) {
        return roomService.getSeatsById(id);
    }

    @GetMapping("/name/{name}/building")
    public String getBuildingByName(@PathVariable String name) {
        return roomService.getBuildingByName(name);
    }

    @GetMapping("/name/{name}/seats")
    public String getSeatsByName(@PathVariable String name) {
        return roomService.getSeatsByName(name);
    }

    @PostMapping
    public String create(@RequestBody RoomVO roomVO) {
        return roomService.create(roomVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody RoomVO roomVO) {
        return roomService.update(id, roomVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return roomService.delete(id);
    }

}


package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.models.dto.RoomDto;
import com.spm.ibooking.services.RoomService;

@RestController
@RequestMapping(value = "/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<RoomDto> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RoomDto getById(@PathVariable Integer id) {
        return roomService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RoomDto create(@RequestBody RoomDto roomDto) {
        return roomService.create(roomDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RoomDto update(@PathVariable Integer id, @RequestBody RoomDto roomDto) {
        return roomService.update(id, roomDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public Void delete(@PathVariable Integer id) {
        roomService.delete(id);
        return null;
    }

}


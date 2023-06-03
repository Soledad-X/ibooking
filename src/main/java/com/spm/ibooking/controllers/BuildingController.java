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

import com.spm.ibooking.models.vo.BuildingVO;
import com.spm.ibooking.services.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public String getAll() {
        return buildingService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return buildingService.getById(id);
    }

    @GetMapping("/{id}/campus")
    public String getCampusById(@PathVariable Integer id) {
        return buildingService.getCampusById(id);
    }

    @GetMapping("/name/{name}/campus")
    public String getCampusByName(@PathVariable String name) {
        return buildingService.getCampusByName(name);
    }

    @GetMapping("/{id}/rooms")
    public String getRoomsById(@PathVariable("id") Integer id) {
        return buildingService.getRoomsById(id);
    }

    @GetMapping("/name/{name}/rooms")
    public String getRoomsByName(@PathVariable String name) {
        return buildingService.getRoomsByName(name);
    }
    
    @PostMapping
    public String create(@RequestBody BuildingVO buildingVO) {
        return buildingService.create(buildingVO);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody BuildingVO buildingVO) {
        return buildingService.update(id, buildingVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return buildingService.delete(id);
    }
}

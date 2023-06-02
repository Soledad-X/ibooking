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

    @GetMapping("/{buildingId}")
    public String getById(@PathVariable Integer buildingId) {
        return buildingService.getById(buildingId);
    }

    @PostMapping
    public String create(@RequestBody BuildingVO buildingVO) {
        return buildingService.create(buildingVO);
    }

    @PatchMapping("/{buildingId}")
    public String update(@PathVariable Integer buildingId, @RequestBody BuildingVO buildingVO) {
        return buildingService.update(buildingId, buildingVO);
    }

    @DeleteMapping("/{buildingId}")
    public String delete(@PathVariable Integer buildingId) {
        return buildingService.delete(buildingId);
    }
}

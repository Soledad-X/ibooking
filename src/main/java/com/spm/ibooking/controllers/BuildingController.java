package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.models.dto.BuildingDto;
import com.spm.ibooking.services.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<BuildingDto> getAll() {
        return buildingService.getAll();
    }

    @GetMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BuildingDto getById(@PathVariable Integer buildingId) {
        return buildingService.getById(buildingId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BuildingDto create(@RequestBody BuildingDto buildingDto) {
        return buildingService.create(buildingDto);
    }

    @PatchMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BuildingDto update(@PathVariable Integer buildingId, @RequestBody BuildingDto buildingDto) {
        return buildingService.update(buildingId, buildingDto);
    }

    @DeleteMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public Void delete(@PathVariable Integer buildingId) {
        buildingService.delete(buildingId);
        return null;
    }
}

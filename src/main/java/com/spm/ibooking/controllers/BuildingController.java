package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.BuildingBo;
import com.spm.ibooking.models.dto.BuildingDto;
import com.spm.ibooking.services.BuildingService;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<BuildingBo>> getAllBuildings() {
        List<BuildingBo> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<BuildingBo> getBuildingById(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        BuildingBo building = buildingService.getBuildingById(buildingId);
        return ResponseEntity.ok(building);
    }

    @PostMapping
    public ResponseEntity<BuildingBo> createBuilding(@RequestBody BuildingDto buildingDto) {
        BuildingBo createdBuilding = buildingService.createBuilding(buildingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuilding);
    }

    @PatchMapping("/{buildingId}")
    public ResponseEntity<BuildingBo> updateBuilding(@PathVariable Integer buildingId, @RequestBody BuildingDto buildingDto) throws ResourceNotFoundException {
        BuildingBo updatedBuilding = buildingService.updateBuilding(buildingId, buildingDto);
        return ResponseEntity.ok(updatedBuilding);
    }

    @DeleteMapping("/{buildingId}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Integer buildingId) throws ResourceNotFoundException {
        buildingService.deleteBuilding(buildingId);
        return ResponseEntity.noContent().build();
    }
}

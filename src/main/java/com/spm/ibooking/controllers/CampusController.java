package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.CampusBO;
import com.spm.ibooking.models.DTO.CampusDTO;
import com.spm.ibooking.services.CampusService;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    
    @Autowired
    private CampusService campusService;

    @GetMapping
    public ResponseEntity<List<CampusBO>> getAllCampuss() {
        List<CampusBO> campuses = campusService.getAllCampuss();
        return ResponseEntity.ok(campuses);
    }

    @GetMapping("/{campusId}")
    public ResponseEntity<CampusBO> getCampusById(@PathVariable Integer campusId) throws ResourceNotFoundException {
        CampusBO campus = campusService.getCampusById(campusId);
        return ResponseEntity.ok(campus);
    }

    @PostMapping
    public ResponseEntity<CampusBO> createCampus(@RequestBody CampusDTO campusDTO) {
        CampusBO createdCampus = campusService.createCampus(campusDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
    }

    @PatchMapping("/{campusId}")
    public ResponseEntity<CampusBO> updateCampus(@PathVariable Integer campusId, @RequestBody CampusDTO campusDTO) throws ResourceNotFoundException {
        CampusBO updatedCampus = campusService.updateCampus(campusId, campusDTO);
        return ResponseEntity.ok(updatedCampus);
    }

    @DeleteMapping("/{campusId}")
    public ResponseEntity<Void> deleteCampus(@PathVariable Integer campusId) throws ResourceNotFoundException {
        campusService.deleteCampus(campusId);
        return ResponseEntity.noContent().build();
    }
}

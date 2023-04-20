package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.entity.Campus;
import com.spm.ibooking.services.CampusService;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    
    @Autowired
    private CampusService campusService;

    @GetMapping
    public ResponseEntity<List<Campus>> getAllCampuss() {
        List<Campus> campuss = campusService.getAllCampuss();
        return ResponseEntity.ok(campuss);
    }

    @GetMapping("/{campusId}")
    public ResponseEntity<Campus> getCampusById(@PathVariable Integer campusId) throws ResourceNotFoundException {
        Campus campus = campusService.getCampusById(campusId);
        return ResponseEntity.ok(campus);
    }

    @PostMapping
    public ResponseEntity<Campus> createCampus(@RequestBody Campus campus) {
        Campus createdCampus = campusService.createCampus(campus);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
    }

    @PutMapping("/{campusId}")
    public ResponseEntity<Campus> updateCampus(@PathVariable Integer campusId, @RequestBody Campus campus) throws ResourceNotFoundException {
        Campus updatedCampus = campusService.updateCampus(campusId, campus);
        return ResponseEntity.ok(updatedCampus);
    }

    @DeleteMapping("/{campusId}")
    public ResponseEntity<Void> deleteCampus(@PathVariable Integer campusId) throws ResourceNotFoundException {
        campusService.deleteCampus(campusId);
        return ResponseEntity.noContent().build();
    }
}

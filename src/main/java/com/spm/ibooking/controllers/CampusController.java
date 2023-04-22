package com.spm.ibooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.spm.ibooking.models.dto.CampusDto;
import com.spm.ibooking.services.CampusService;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    
    @Autowired
    private CampusService campusService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CampusDto> getAll() {
        return campusService.getAll();
    }

    @GetMapping("/{campusId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CampusDto getById(@PathVariable Integer campusId) {        
        return campusService.getById(campusId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CampusDto create(@RequestBody CampusDto campusDto) {        
        return campusService.create(campusDto);
    }

    @PatchMapping("/{campusId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CampusDto update(@PathVariable Integer campusId, @RequestBody CampusDto campusDto) {
        return campusService.update(campusId, campusDto);
    }

    @DeleteMapping("/{campusId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public Void delete(@PathVariable Integer campusId) {
        campusService.delete(campusId);
        return null;
    }
}

package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.DO.CampusDO;
import com.spm.ibooking.repositories.CampusRepository;

@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    public List<CampusDO> getAllCampuss() {
        return campusRepository.findAll();
    }

    public CampusDO getCampusById(Integer id) {
        return campusRepository.findById(id).orElse(null);
    }

    public CampusDO createCampus(CampusDO campus) {
        return campusRepository.save(campus);
    }

    public CampusDO updateCampus(Integer id, CampusDO campus) {
        Optional<CampusDO> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            CampusDO existingCampus = optionalCampus.get();
            existingCampus.setName(campus.getName());
            existingCampus.setAddress(campus.getAddress());
            existingCampus.setCity(campus.getCity());
            existingCampus.setBuildings(campus.getBuildings());
            // set other fields you want to update
            return campusRepository.save(existingCampus);
        }
        throw new ResourceNotFoundException("Campus not found with id " + id);
    }

    public void deleteCampus(Integer id) {
        Optional<CampusDO> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            campusRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Campus not found with id " + id);
        }
    }
}


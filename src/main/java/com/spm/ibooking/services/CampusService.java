package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.BO.CampusBO;
import com.spm.ibooking.models.DTO.CampusDTO;
import com.spm.ibooking.models.PO.Campus;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    public List<CampusBO> getAllCampuss() {
        return BeanUtils.convertListTo(campusRepository.findAll(), CampusBO::new, true);
    }

    public CampusBO getCampusById(Integer id) {
        return BeanUtils.convertTo(campusRepository.findById(id).orElse(null), CampusBO::new, true);
    }

    public CampusBO createCampus(CampusDTO campusDTO) {
        Campus campus = BeanUtils.convertTo(campusDTO, Campus::new, true);
        return BeanUtils.convertTo(campusRepository.save(campus), CampusBO::new, true);
    }

    public CampusBO updateCampus(Integer id, CampusDTO campusDTO) {
        Optional<Campus> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            Campus campus = optionalCampus.get();
            // campus.setName(campusDTO.getName());
            // campus.setAddress(campusDTO.getAddress());
            // campus.setCity(campusDTO.getCity());
            // campus.setCampuss(campusDTO.getCampuss());
            campus = BeanUtils.convertTo(campusDTO, Campus::new, true);
            campus.setId(id); 
            // set other fields you want to update
            return BeanUtils.convertTo(campusRepository.save(campus), CampusBO::new, true);
        }
        throw new ResourceNotFoundException("Campus not found with id " + id);
    }

    public void deleteCampus(Integer id) {
        Optional<Campus> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            campusRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Campus not found with id " + id);
        }
    }
}


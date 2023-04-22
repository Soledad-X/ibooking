package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.BuildingBo;
import com.spm.ibooking.models.bo.CampusBo;
import com.spm.ibooking.models.dto.CampusDto;
import com.spm.ibooking.models.po.Campus;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    public List<CampusBo> getAllCampuss() {
        return BeanUtils.convertListTo(campusRepository.findAll(), CampusBo::new, true,
            (s, t) -> t.setBuildings(BeanUtils.convertListTo(s.getBuildings(), BuildingBo::new)));
    }

    public CampusBo getCampusById(Integer id) {
        return BeanUtils.convertTo(campusRepository.findById(id).orElse(null), CampusBo::new, true,
        (s, t) -> t.setBuildings(BeanUtils.convertListTo(s.getBuildings(), BuildingBo::new)));
    }

    public CampusBo createCampus(CampusDto campusDto) {
        Campus campus = BeanUtils.convertTo(campusDto, Campus::new, true);
        return BeanUtils.convertTo(campusRepository.save(campus), CampusBo::new, true);
    }

    public CampusBo updateCampus(Integer id, CampusDto campusDto) {
        Optional<Campus> optionalCampus = campusRepository.findById(id);
        if (optionalCampus.isPresent()) {
            Campus campus = optionalCampus.get();
            BeanUtils.copyTo(campusDto, campus, true);
            campus = BeanUtils.convertTo(campusDto, Campus::new, true);
            campus.setId(id); 
            // set other fields you want to update
            return BeanUtils.convertTo(campusRepository.save(campus), CampusBo::new, true);
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


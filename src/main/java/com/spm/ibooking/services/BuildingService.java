package com.spm.ibooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.spm.ibooking.exceptions.ResourceNotFoundException;
import com.spm.ibooking.models.bo.BuildingBo;
import com.spm.ibooking.models.bo.CampusBo;
import com.spm.ibooking.models.dto.BuildingDto;
import com.spm.ibooking.models.po.Building;
import com.spm.ibooking.repositories.BuildingRepository;
import com.spm.ibooking.repositories.CampusRepository;
import com.spm.ibooking.utils.BeanUtils;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private CampusRepository campusRepository;
    
    public List<BuildingBo> getAllBuildings() {
        return BeanUtils.convertListTo(buildingRepository.findAll(), BuildingBo::new, true,
            (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusBo::new, true)));
    }

    public BuildingBo getBuildingById(Integer id) {
        return BeanUtils.convertTo(buildingRepository.findById(id).orElse(null), BuildingBo::new, true,
            (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusBo::new, true)));
    }

    public BuildingBo createBuilding(BuildingDto buildingDto) {
        Building building = BeanUtils.convertTo(buildingDto, Building::new, true,
            (s, t) -> t.setCampus(campusRepository.findById(s.getCampusId()).orElse(null)));        
        return BeanUtils.convertTo(buildingRepository.save(building), BuildingBo::new, true);
    }

    public BuildingBo updateBuilding(Integer id, BuildingDto buildingDto) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            Building building = optionalBuilding.get();
            BeanUtils.CopyTo(buildingDto, building, true, 
                (s, t) -> t.setCampus(campusRepository.findById(s.getCampusId()).orElse(null)));
            return BeanUtils.convertTo(buildingRepository.save(building), BuildingBo::new, true,
                (s, t) -> t.setCampus(BeanUtils.convertTo(s.getCampus(), CampusBo::new, true)));
        }
        throw new ResourceNotFoundException("Building not found with id " + id);
    }

    public void deleteBuilding(Integer id) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            buildingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Building not found with id " + id);
        }
    }
}

package com.spm.ibooking.models.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusBo {
    
    private Integer id;

    private String name;

    private String address;

    private String city;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
    @JsonIgnoreProperties(value = {"campus"})
    private List<BuildingBo> buildings = new ArrayList<>();
    
    public void addBuilding(BuildingBo building) {
        buildings.add(building);
        building.setCampus(this);
    }
    
    public void removeBuilding(BuildingBo building) {
        buildings.remove(building);
        building.setCampus(null);
    }
}


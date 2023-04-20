package com.spm.ibooking.models.DO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name = "campuses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusDO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @OneToMany(mappedBy = "campus", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"campus"})
    private List<BuildingDO> buildings = new ArrayList<>();
    
    public void addBuilding(BuildingDO building) {
        buildings.add(building);
        building.setCampus(this);
    }
    
    public void removeBuilding(BuildingDO building) {
        buildings.remove(building);
        building.setCampus(null);
    }
}


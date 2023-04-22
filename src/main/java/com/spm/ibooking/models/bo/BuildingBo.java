package com.spm.ibooking.models.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingBo {
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    @JsonIgnoreProperties(value = {"buildings"})
    private CampusBo campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}


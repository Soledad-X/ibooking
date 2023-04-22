package com.spm.ibooking.models.BO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingBO {
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    @JsonIgnoreProperties(value = {"buildings"})
    private CampusBO campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}


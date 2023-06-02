package com.spm.ibooking.models.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BuildingVO implements Serializable{
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer campusId;
    
    @JsonIgnoreProperties(value = {"buildings"})
    private CampusVO campus;

    // private Date createdAt;

    // private Date updatedAt;
    
}


package com.spm.ibooking.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuildingDto implements Serializable{
    
    private Integer id;
    
    private String name;
    
    private String alias;
    
    private Integer floor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer campusId;
    
    @JsonIgnoreProperties(value = {"buildings"})
    private CampusDto campus;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}


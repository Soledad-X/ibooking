package com.spm.ibooking.models.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampusVO implements Serializable{
    
    private Integer id;

    private String name;

    private String address;

    private String city;

    // private Date createdAt;

    // private Date updatedAt;

    @JsonIgnoreProperties(value = {"campus"})
    private List<BuildingVO> buildings = new ArrayList<>();
    
}


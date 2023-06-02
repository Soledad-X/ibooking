package com.spm.ibooking.models.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CampusVO implements Serializable{
    
    private Integer id;

    private String name;

    private String address;

    private String city;

    // private Date createdAt;

    // private Date updatedAt;

    // @JsonIgnoreProperties(value = {"campus"})
    // private List<BuildingVO> buildings = new ArrayList<>();
    
}


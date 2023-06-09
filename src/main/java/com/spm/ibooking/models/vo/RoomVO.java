package com.spm.ibooking.models.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoomVO implements Serializable{

    private Integer id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer buildingId;

    @JsonIgnoreProperties(value = {"campus"})
    private BuildingVO building;

    private Integer floor;

    @JsonIgnoreProperties(value = {"room"})
    private List<SeatVO> seats = new ArrayList<>();

    // private Date createdAt;

    // private Date updatedAt;

}

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
public class RoomDto implements Serializable{

    private Integer id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer buildingId;

    @JsonIgnoreProperties(value = {"campus"})
    private BuildingDto building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

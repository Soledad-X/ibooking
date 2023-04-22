package com.spm.ibooking.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto implements Serializable{

    private Integer id;

    private String name;

    private Integer buldingId;

    private BuildingDto building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

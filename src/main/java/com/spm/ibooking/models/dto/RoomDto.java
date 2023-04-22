package com.spm.ibooking.models.dto;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto implements Serializable{

    private Integer id;

    private String name;

    private Integer buldingId;

    private BuildingDto building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

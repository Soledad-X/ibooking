package com.spm.ibooking.models.DTO;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO implements Serializable{

    private Integer id;

    private String name;

    private Integer buldingId;

    private BuildingDTO building;

    private Integer floor;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

package com.spm.ibooking.models.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spm.ibooking.models.enums.SeatStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeatDto implements Serializable{

    private Integer id;

    private Integer roomId;
    
    private RoomDto room;

    private Boolean hasPower;

    private SeatStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}


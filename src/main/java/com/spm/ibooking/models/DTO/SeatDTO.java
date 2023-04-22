package com.spm.ibooking.models.DTO;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

import com.spm.ibooking.models.enums.SeatStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO implements Serializable{

    private Integer id;

    private Integer roomId;
    
    private RoomDTO room;

    private Boolean hasPower;

    private SeatStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}


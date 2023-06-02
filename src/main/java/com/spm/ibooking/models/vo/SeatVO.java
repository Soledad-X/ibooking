package com.spm.ibooking.models.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.ibooking.models.enums.SeatStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SeatVO implements Serializable{

    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer roomId;
    
    @JsonIgnoreProperties(value = {"buildings", "seats"})
    private RoomVO room;

    private Integer seatNumber;

    private Boolean hasPower;

    private SeatStatus status;

    // private Date statusUpdatedAt;

    // private Date createdAt;

    // private Date updatedAt;
    
}


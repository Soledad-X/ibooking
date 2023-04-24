package com.spm.ibooking.models.dto;

import lombok.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.ibooking.models.enums.SeatStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeatDto implements Serializable{

    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer roomId;
    
    @JsonIgnoreProperties(value = {"buildings", "seats"})
    private RoomDto room;

    private Integer seatNumber;

    private Boolean hasPower;

    private SeatStatus status;

    // private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}


package com.spm.ibooking.models.dto;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spm.ibooking.models.enums.ReservationStatus;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto implements Serializable {

    private Integer id;

    private Integer userId;

    private UserDto user;

    private Integer seatId;

    private SeatDto seat;

    private Timestamp startTime;

    private Timestamp endTime;

    private ReservationStatus status;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

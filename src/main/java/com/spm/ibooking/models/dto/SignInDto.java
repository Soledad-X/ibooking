package com.spm.ibooking.models.dto;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spm.ibooking.models.enums.SignInStatus;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignInDto implements Serializable{

    private Integer id;

    private Integer reservationId;

    private ReservationDto reservation;
    
    private SignInStatus status;

    private Timestamp startTime;

    private Timestamp signInTime;

    private Timestamp signOutTime;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

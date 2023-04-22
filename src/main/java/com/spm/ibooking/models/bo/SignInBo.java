package com.spm.ibooking.models.bo;

import lombok.*;

import com.spm.ibooking.models.enums.SignInStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInBo {

    private Long id;

    private ReservationBo reservation;

    private SignInStatus status;

    private Timestamp startTime;

    private Timestamp signInTime;

    private Timestamp signOutTime;

    private Timestamp statusUpdatedAt;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;

}

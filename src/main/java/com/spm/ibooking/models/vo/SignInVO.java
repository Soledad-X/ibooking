package com.spm.ibooking.models.vo;

import java.io.Serializable;
import java.util.Date;

import com.spm.ibooking.models.enums.SignInStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SignInVO implements Serializable{

    private Integer id;

    private Integer reservationId;

    private ReservationVO reservation;
    
    private SignInStatus status;

    
    private Date startTime;

    
    private Date signInTime;

    
    private Date signOutTime;

    
    private Date statusUpdatedAt;

    // private Date createdAt;

    // private Date updatedAt;

}

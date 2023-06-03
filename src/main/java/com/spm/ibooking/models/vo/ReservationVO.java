package com.spm.ibooking.models.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.ibooking.models.enums.ReservationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationVO implements Serializable {

    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    private UserVO user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer seatId;

    private SeatVO seat;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private ReservationStatus status;

    // private Date statusUpdatedAt;

    // private Date createdAt;

    // private Date updatedAt;

}

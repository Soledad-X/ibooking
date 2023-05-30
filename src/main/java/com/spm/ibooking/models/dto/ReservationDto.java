package com.spm.ibooking.models.dto;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.ibooking.models.enums.ReservationStatus;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto implements Serializable {

    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;

    private UserDto user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer seatId;

    private SeatDto seat;

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

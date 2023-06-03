package com.spm.ibooking.models.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spm.ibooking.models.enums.ReservationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    @Column(insertable = false, updatable = false)
    private Date statusUpdatedAt;

    /**
     * Each reservation must corresponds to one user(user_id).
     * 
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    /**
     * Each reservation must corresponds to one seat(seat_id).
     * 
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "seat_id")
    @JsonIgnore
    private Seat seat;

    /**
     * One reservation must corresponds to one signIn(signIn_id).
     * 
     */
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "reservation")
    @JsonIgnore
    private SignIn signIn;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date createdAt;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date updatedAt;
}

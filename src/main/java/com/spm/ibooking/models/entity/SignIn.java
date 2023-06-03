package com.spm.ibooking.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spm.ibooking.models.enums.SignInStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sign_ins")
public class SignIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SignInStatus status;

    @Column(nullable = false, updatable = false)
    private Date startTime;

    private Date signInTime;

    private Date signOutTime;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date statusUpdatedAt;

    /**
     * One signIn must corresponds to one reservation(reservation_id).
     * 
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "reservation_id")
    @JsonIgnore
    private Reservation reservation;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date createdAt;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date updatedAt;
}

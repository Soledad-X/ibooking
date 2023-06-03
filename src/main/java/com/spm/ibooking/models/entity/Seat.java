package com.spm.ibooking.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spm.ibooking.models.enums.SeatStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer seatNumber;

    @Column(nullable = false)
    private Boolean hasPower;
  
    @Enumerated(EnumType.STRING)
    @Column
    private SeatStatus status;

    @Column(insertable = false, updatable = false)
    private Date statusUpdatedAt;

    /**
     * Each seat must corresponds to one room(room_id).
     * 
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;

    /**
     * Each buldings has mutiple reservations.
     * 
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seat")
    @JsonIgnore
    private List<Reservation> reservations;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date createdAt;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date updatedAt;
}


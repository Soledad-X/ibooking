package com.spm.ibooking.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;
    
    /**
     * Each room must corresponds to one building(building_id).
     * 
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id")
    @JsonIgnore
    private Building building;

    /**
     * Each room has multiple seats.
     * 
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
    @JsonIgnore
    private List<Seat> seats = new ArrayList<>();

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date createdAt;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date updatedAt;
}

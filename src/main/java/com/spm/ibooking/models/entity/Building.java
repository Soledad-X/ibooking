package com.spm.ibooking.models.entity;

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
@Table(name = "buildings")
public class Building {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(insertable = false, updatable = false)
    private Integer id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    @Column
    private String alias;
    
    @Column
    private Integer floor;

    /**
     * Each building must corresponds to one campus(campus_id).
     * 
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "campus_id")
    @JsonIgnore
    private Campus campus;
    
    /**
     * Each buldings has mutiple rooms.
     * 
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "building")
    @JsonIgnore
    private List<Room> rooms;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date createdAt;

    @Column(insertable = false, updatable = false)
    @JsonIgnore
    private Date updatedAt;
    
}


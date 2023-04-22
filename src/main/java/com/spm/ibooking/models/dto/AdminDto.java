package com.spm.ibooking.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto implements Serializable {

    private Integer id;
    
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String phone;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
}
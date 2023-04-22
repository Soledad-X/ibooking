package com.spm.ibooking.models.DTO;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO implements Serializable {

    private Integer id;
    
    private String username;

    private String password;

    private String email;

    private String phone;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
}
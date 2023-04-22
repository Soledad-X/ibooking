package com.spm.ibooking.models.bo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBo {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    // private Timestamp createdAt;

    // private Timestamp updatedAt;
    
}
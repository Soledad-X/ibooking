package com.spm.ibooking.models.vo;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable{

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;
}
package com.peppermint.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String avatar;
    private String email;
    private String password;
    private Integer status;
    private Date created;
    private Date lastLogin;
}

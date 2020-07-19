package com.peppermint.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class Blog {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private String content;
    private Date created;
    private Short status;

}

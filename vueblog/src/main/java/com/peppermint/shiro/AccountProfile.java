package com.peppermint.shiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
}

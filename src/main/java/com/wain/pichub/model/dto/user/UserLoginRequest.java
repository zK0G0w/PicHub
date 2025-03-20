package com.wain.pichub.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2025/3/17 15:12
 */

@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;
}

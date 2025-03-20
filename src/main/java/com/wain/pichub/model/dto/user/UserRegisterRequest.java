package com.wain.pichub.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户注册
 * @Author: WainZeng
 * @Date: 2025/2/26 19:07
 */

@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 确认密码
     */
    private String checkPassword;

}

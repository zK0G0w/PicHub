package com.wain.pichub.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户添加请求
 * @Author: WainZeng
 * @Date: 2025/3/18 14:50
 */

@Data
public class UserAddRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色: user / admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}

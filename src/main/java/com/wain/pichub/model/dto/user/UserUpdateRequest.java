package com.wain.pichub.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户更新请求
 * @Author: WainZeng
 * @Date: 2025/3/18 14:52
 */

@Data
public class UserUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

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

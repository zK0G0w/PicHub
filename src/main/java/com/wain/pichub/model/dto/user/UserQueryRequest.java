package com.wain.pichub.model.dto.user;

import com.wain.pichub.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description: 用户查询请求
 * @Author: WainZeng
 * @Date: 2025/3/18 14:52
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;


    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色 user / admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}

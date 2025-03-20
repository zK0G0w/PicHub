package com.wain.pichub.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

/**
 * @Description: 用户角色枚举类
 * @Author: WainZeng
 * @Date: 2025/2/26 18:20
 */

@Getter
public enum UserRoleEnum {

    USER("用户", "user"),
    ADMIN("管理员","admin");

    private final String text;

    private final String value;

    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }


    public static UserRoleEnum getEnumByValue(String value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        for (UserRoleEnum anEnum : UserRoleEnum.values()) {
            if (anEnum.getValue().equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

}

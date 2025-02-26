package com.wain.pichub.common;

import com.wain.pichub.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 响应包装类
 * @Author: WainZeng
 * @Date: 2025/2/24 17:04
 */

@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null,errorCode.getMessage());
    }

}

package com.wain.pichub.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 删除请求包装类
 * @Author: WainZeng
 * @Date: 2025/2/24 17:04
 */

@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;

}

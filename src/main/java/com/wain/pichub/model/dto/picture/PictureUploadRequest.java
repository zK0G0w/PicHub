package com.wain.pichub.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 图片上传请求
 * @Author: WainZeng
 * @Date: 2025/3/25 15:18
 */

@Data
public class PictureUploadRequest implements Serializable {

    /**
     * 图片 id (用于修改)
     **/
    private Long id;

    private static final long serialVersionUID = 1L;
}

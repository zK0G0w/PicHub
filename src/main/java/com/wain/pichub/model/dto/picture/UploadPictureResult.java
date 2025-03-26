package com.wain.pichub.model.dto.picture;

import lombok.Data;

/**
 * @Description: 接收图片解析信息的包装类
 * @Author: WainZeng
 * @Date: 2025/3/25 15:45
 */

@Data
public class UploadPictureResult {

    /**
     * 图片 url
     */
    private String url;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 图片体积
     */
    private Long picSize;

    /**
     * 图片宽度
     */
    private Integer picWidth;

    /**
     * 图片高度
     */
    private Integer picHeight;

    /**
     * 图片宽高比例
     */
    private Double picScale;

    /**
     * 图片格式
     */
    private String picFormat;

}

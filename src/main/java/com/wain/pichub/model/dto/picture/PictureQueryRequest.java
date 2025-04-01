package com.wain.pichub.model.dto.picture;

import com.wain.pichub.common.PageRequest;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 查询图片请求
 * @Author: WainZeng
 * @Date: 2025/3/31 15:22
 */

@Data
public class PictureQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 分类
     */
    private String category;

    /**
     * 标签
     */
    private List<String> tags;

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

    /**
     * 搜索词(同时搜名称,简介等)
     */
    private String searchText;

    /**
     * 创建用户id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}

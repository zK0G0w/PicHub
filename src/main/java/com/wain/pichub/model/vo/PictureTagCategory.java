package com.wain.pichub.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2025/4/1 16:46
 */

@Data
public class PictureTagCategory {

    /**
     * 标签列表
     */
    private List<String> tagList;

    /**
     * 分类列表
     */
    private List<String> categoryList;
}

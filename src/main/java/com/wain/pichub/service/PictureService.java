package com.wain.pichub.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wain.pichub.model.dto.picture.PictureQueryRequest;
import com.wain.pichub.model.dto.picture.PictureUploadRequest;
import com.wain.pichub.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wain.pichub.model.entity.User;
import com.wain.pichub.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wainzeng
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2025-03-25 14:58:23
 */
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    /**
     * 获取查询对象
     *
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 获取单个图片封装类
     *
     * @param picture
     * @param request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页获取图片封装类
     *
     * @param picturePage
     * @param request
     * @return
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 图片数据校验
     *
     * @param picture
     * @return
     */
    void validPicture(Picture picture);
}

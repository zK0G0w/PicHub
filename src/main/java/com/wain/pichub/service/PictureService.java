package com.wain.pichub.service;

import com.wain.pichub.model.dto.picture.PictureUploadRequest;
import com.wain.pichub.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wain.pichub.model.entity.User;
import com.wain.pichub.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

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
}

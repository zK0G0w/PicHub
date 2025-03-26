package com.wain.pichub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wain.pichub.exception.ErrorCode;
import com.wain.pichub.exception.ThrowUtils;
import com.wain.pichub.manager.FileManager;
import com.wain.pichub.model.dto.picture.PictureUploadRequest;
import com.wain.pichub.model.dto.picture.UploadPictureResult;
import com.wain.pichub.model.entity.Picture;
import com.wain.pichub.model.entity.User;
import com.wain.pichub.model.vo.PictureVO;
import com.wain.pichub.service.PictureService;
import com.wain.pichub.mapper.PictureMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wainzeng
 * @description 针对表【picture(图片)】的数据库操作Service实现
 * @createDate 2025-03-25 14:58:23
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
        implements PictureService {

    @Resource
    private FileManager fileManager;

    @Override
    public PictureVO uploadPicture(MultipartFile multipartFile, PictureUploadRequest pictureUploadRequest, User loginUser) {
        ThrowUtils.throwIf(loginUser == null, ErrorCode.NO_AUTH_ERROR);
        //判断为新增图片还是更新图片
        Long pictureId = null;
        if (pictureUploadRequest != null) {
            pictureId = pictureUploadRequest.getId();
        }
        // 如果是更新图片,需要校验图片是否存在
        if (pictureId != null) {
            boolean exists = this.lambdaQuery()
                    .eq(Picture::getId, pictureId)
                    .exists();
            ThrowUtils.throwIf(!exists, ErrorCode.NO_AUTH_ERROR, "图片不存在");
        }
        // 上传图片,得到信息
        // 按照用户 id 划分目录
        String uploadPathPrefix = String.format("public/%s", loginUser.getId());
        UploadPictureResult uploadPictureResult = fileManager.uploadPicture(multipartFile, uploadPathPrefix);
        // 构造入库的图片信息
        Picture picture = new Picture();
        picture.setUrl(uploadPictureResult.getUrl());
        picture.setName(uploadPictureResult.getPicName());
        picture.setPicSize(uploadPictureResult.getPicSize());
        picture.setPicWidth(uploadPictureResult.getPicWidth());
        picture.setPicHeight(uploadPictureResult.getPicHeight());
        picture.setPicScale(uploadPictureResult.getPicScale());
        picture.setPicFormat(uploadPictureResult.getPicFormat());
        picture.setUserId(loginUser.getId());
        // 如果 pictureId 不为空,表示更新,否则是新增
        if (pictureId != null) {
            // 如果是更新,要补充 id 和 编辑时间
            picture.setId(pictureId);
            picture.setEditTime(new Date());
        }
        boolean result = this.saveOrUpdate(picture);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR, "图片上传失败");
        return PictureVO.objToVo(picture);
    }

}





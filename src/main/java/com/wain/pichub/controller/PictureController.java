package com.wain.pichub.controller;

import com.wain.pichub.annotation.AuthCheck;
import com.wain.pichub.common.BaseResponse;
import com.wain.pichub.common.ResultUtils;
import com.wain.pichub.constant.UserConstant;
import com.wain.pichub.model.dto.picture.PictureUploadRequest;
import com.wain.pichub.model.entity.User;
import com.wain.pichub.model.vo.PictureVO;
import com.wain.pichub.service.PictureService;
import com.wain.pichub.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 图片操作Controller
 * @Author: WainZeng
 * @Date: 2025/3/26 09:21
 */

@Slf4j
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Resource
    private PictureService pictureService;

    @Resource
    private UserService userService;


    @PostMapping("/upload")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<PictureVO> uploadPicture(@RequestPart("file") MultipartFile multipartFile,
                                                 PictureUploadRequest pictureUploadRequest,
                                                 HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        PictureVO pictureVO = pictureService.uploadPicture(multipartFile, pictureUploadRequest, loginUser);
        return ResultUtils.success(pictureVO);

    }
}

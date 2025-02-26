package com.wain.pichub.controller;

import com.wain.pichub.common.BaseResponse;
import com.wain.pichub.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2025/2/26 16:57
 */

@RestController
@RequestMapping("/")
public class MainController {

    /**
     * 健康检查
     *
     * @return ok
     */
    @GetMapping("/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("application is running");
    }
}

package com.wain.pichub.aop;

import com.wain.pichub.annotation.AuthCheck;
import com.wain.pichub.exception.BusinessException;
import com.wain.pichub.exception.ErrorCode;
import com.wain.pichub.model.entity.User;
import com.wain.pichub.model.enums.UserRoleEnum;
import com.wain.pichub.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 权限校验aop
 * @Author: WainZeng
 * @Date: 2025/3/18 14:33
 */

@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    public Object doIntercept(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        //当前登录用户
        User loginUser = userService.getLoginUser(request);
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        //不需要权限,直接放行
        if (mustRoleEnum == null) {
            return joinPoint.proceed();
        }
        //以下为: 必须拥有权限才能通过
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        //用户没有权限,直接拒绝
        if (userRoleEnum == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        //要求有管理员权限,但该用户不是管理员权限,拒绝
        if (UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        //通过权限校验,放行
        return joinPoint.proceed();
    }

}

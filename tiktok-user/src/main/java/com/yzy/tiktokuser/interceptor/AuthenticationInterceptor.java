package com.yzy.tiktokuser.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yzy.tiktokcommon.annotation.UserLoginToken;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.common.ErrorCode;

import com.yzy.tiktokcommon.exception.BusinessException;
import com.yzy.tiktokuser.service.UserService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 7:44
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Resource
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不是方法
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                if (token == null || token.isEmpty()) {
                    throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "token不存在");
                }
            }
            Long userId;
            userId = Long.parseLong(JWT.decode(token).getAudience().get(0));

            User user = userService.getByUserId(userId);
            if (user == null) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "用户不存在，请重新登录");
            }


            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try {
                verifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "token认证失败，重新登录");
            }
            return true;
        }
        return true;

    }

}

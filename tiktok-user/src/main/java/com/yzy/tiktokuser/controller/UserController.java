package com.yzy.tiktokuser.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.common.ErrorCode;
import com.yzy.tiktokcommon.exception.BusinessException;
import com.yzy.tiktokcommon.entity.request.user.UserInfoRequest;
import com.yzy.tiktokcommon.entity.request.user.UserRegisterRequest;
import com.yzy.tiktokcommon.entity.response.UserLoginResponse;
import com.yzy.tiktokcommon.entity.response.UserRegisterResponse;
import com.yzy.tiktokuser.service.UserService;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/5 20:32
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 注册
     *
     * @param request
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "request为空");
        }
        String username = request.getUsername();
        String password = request.getPassword();
        Long userId = userService.register(username, password);
        UserRegisterResponse response = new UserRegisterResponse();
        response.setUserId(LongToString(userId));
        String token = TokenUtil.getToken(userService.getByUserId(userId));
        response.setToken(token);
        return ResultUtils.success(response);
    }

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<UserLoginResponse> login(@RequestBody UserRegisterRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "request为空");
        }
        String username = request.getUsername();
        String password = request.getPassword();
        Long userId = userService.login(username, password);
        if (userId < 0) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "user不存在");
        }
        UserLoginResponse response = new UserLoginResponse();
        response.setUserId(LongToString(userId));
        User user = userService.getById(userId);
        String token = TokenUtil.getToken(user);
        response.setToken(token);
        return ResultUtils.success(response);
    }

    /**
     * 用户信息
     *
     * @param request
     * @return
     */
    @GetMapping
    public BaseResponse<User> userInfo(UserInfoRequest request) {
        User user = userService.getByUserId(Long.parseLong(request.getUserId()));
        String token = request.getToken();
        checkToken(request);
        return ResultUtils.success(user);
    }

    private void checkToken(UserInfoRequest request) {
        String token = request.getToken();
        Long userId = Long.parseLong(JWT.decode(token).getAudience().get(0));
        User user = userService.getByUserId(userId);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "token认证失败");
        }
    }

    public String LongToString(Long userId) {
        return String.valueOf(userId);
    }
}

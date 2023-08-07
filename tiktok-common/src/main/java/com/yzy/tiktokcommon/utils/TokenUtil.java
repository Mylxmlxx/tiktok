package com.yzy.tiktokcommon.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.yzy.tiktokcommon.common.ErrorCode;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.exception.BusinessException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 0:18
 */
public class TokenUtil {
    public static String getToken(User user) {
        Date start = new Date();
        long validTime = System.currentTimeMillis() + 60 * 60 * 60 * 1000;
        Date end = new Date(validTime);
        String token = JWT.create()
                .withAudience(String.valueOf(user.getId()))
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    public static String checkToken(String token) {
        try {
            return JWT.decode(token).getAudience().get(0);
        } catch (BusinessException e) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "token解析失败");
        }
    }
}

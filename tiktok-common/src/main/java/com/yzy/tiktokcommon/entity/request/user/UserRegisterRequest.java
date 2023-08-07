package com.yzy.tiktokcommon.entity.request.user;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/5 21:53
 */
@Data
public class UserRegisterRequest {
    private String username;
    private String password;
}

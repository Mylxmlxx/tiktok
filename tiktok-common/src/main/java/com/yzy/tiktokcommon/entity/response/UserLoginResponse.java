package com.yzy.tiktokcommon.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/5 22:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
    String userId;
    String token;
}

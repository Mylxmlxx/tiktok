package com.yzy.tiktokcommon.entity.request.message;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 19:39
 */
@Data
public class ChatListRequest {
    String token;
    String toUserId;
}

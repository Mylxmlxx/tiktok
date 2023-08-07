package com.yzy.tiktokcommon.entity.request.message;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 19:02
 */
@Data
public class SendMessageRequest {
    String token;
    String userId;
    String actionType;
    String content;
}

package com.yzy.tiktokcommon.entity.request.realtion;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 9:59
 */
@Data
public class FollowRequest {
    String token;
    String userId;
    /**
     * 1 关注 2 取消关注
     */
    String actionType;
}

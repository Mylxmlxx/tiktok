package com.yzy.tiktokcommon.entity.request.video;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/7 16:31
 */
@Data
public class FeedRequest {
    /**
     * 最新投稿时间戳
     */
    String latestTime;
    String token;
}

package com.yzy.tiktokcommon.entity.request.comment;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 21:30
 */
@Data
public class CommentListRequest {
    String token;
    String videoId;
}

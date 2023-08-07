package com.yzy.tiktokcommon.entity.request.comment;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 20:43
 */
@Data
public class CommentActionRequest {
    String token;
    String videoId;
    String actionType;
    String content;
    String commentId;
}

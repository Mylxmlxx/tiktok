package com.yzy.tiktokcommon.entity.response;

import com.yzy.tiktokcommon.entity.domain.User;
import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 20:41
 */
@Data
public class CommentResponse {
    String content;
    User user;
}

package com.yzy.tiktokcommon.entity.request.favorite;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 21:48
 */
@Data
public class FavoriteActionRequest {
    String token;
    String videoId;
    String actionType;
}

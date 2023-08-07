package com.yzy.tiktokcommon.entity.request.favorite;

import lombok.Data;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 23:29
 */
@Data
public class FavoriteListRequest {
    String token;
    String userId;
}

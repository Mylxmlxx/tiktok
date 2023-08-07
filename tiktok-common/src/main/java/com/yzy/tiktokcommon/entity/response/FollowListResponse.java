package com.yzy.tiktokcommon.entity.response;

import com.yzy.tiktokcommon.entity.domain.User;
import lombok.Data;

import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 11:02
 */
@Data
public class FollowListResponse {
    List<User> userList;
}

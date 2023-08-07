package com.yzy.tiktokrelation.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yzy.tiktokcommon.entity.domain.Follow;
import com.yzy.tiktokcommon.entity.domain.User;

import java.util.List;

/**
 * @author Lenovo
 * @description 针对表【follow】的数据库操作Service
 * @createDate 2023-08-05 21:26:37
 */
public interface FollowService extends IService<Follow> {

    void follow(String followId, String followerId, String actionType);

    List<User> followList(String userId);

    List<User> followerList(String userId);

    List<User> getFriendList(String userId);
}

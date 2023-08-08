package com.yzy.tiktokrelation.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.tiktokcommon.entity.domain.Follow;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.rpcservice.RpcUserService;
import com.yzy.tiktokrelation.mapper.FollowMapper;
import com.yzy.tiktokrelation.service.FollowService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 * @description 针对表【follow】的数据库操作Service实现
 * @createDate 2023-08-05 21:26:37
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow>
        implements FollowService {

    @DubboReference
    RpcUserService rpcUserService;

    @Override
    public void follow(String followId, String followerId, String actionType) {
        if (actionType.equals("1")) {
            Follow follow = new Follow();
            follow.setFollowerId(Long.parseLong(followerId));
            follow.setFollowId(Long.parseLong(followId));

            // TODO 互关
            save(follow);
        }
    }

    @Override
    public List<User> followList(String userId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getFollowerId, Long.parseLong(userId));
        List<Long> followIds = list(wrapper).stream().map(Follow::getFollowId).collect(Collectors.toList());

        // RPC 调用
        List<User> users = rpcUserService.getUserListByIds(followIds);
        return users;
    }

    @Override
    public List<User> followerList(String userId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getFollowId, Long.parseLong(userId));
        List<Long> followIds = list(wrapper).stream().map(Follow::getFollowerId).collect(Collectors.toList());

        // RPC 调用
        List<User> users = rpcUserService.getUserListByIds(followIds);
        return users;
    }

    @Override
    public List<User> getFriendList(String userId) {
        LambdaQueryWrapper<Follow> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Follow::getIsMutual, 1);
        wrapper.eq(Follow::getFollowId, Long.parseLong(userId)).or().eq(Follow::getFollowerId, Long.parseLong(userId));
        List<Follow> list = list(wrapper);
        List<Long> ids = list.stream()
                .map(Follow::getFollowerId)
                .filter(aLong -> aLong != Long.parseLong(userId))
                .collect(Collectors.toList());
        List<User> users = rpcUserService.getUserListByIds(ids);
        return users;
    }
}





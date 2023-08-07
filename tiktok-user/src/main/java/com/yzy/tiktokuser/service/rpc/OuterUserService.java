package com.yzy.tiktokuser.service.rpc;

import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.rpcservice.RpcUserService;
import com.yzy.tiktokuser.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 12:49
 */
@DubboService
public class OuterUserService implements RpcUserService {

    @Resource
    UserService userService;

    @Override
    public List<User> getUserListByIds(List<Long> ids) {
        if (ids.isEmpty()) return Collections.emptyList();
        List<User> users = userService.listByIds(ids);
        return users;
    }

    @Override
    public List<User> getFriends(Long userId) {
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return userService.getByUserId(userId);
    }
}

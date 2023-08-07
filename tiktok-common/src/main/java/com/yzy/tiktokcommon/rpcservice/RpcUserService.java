package com.yzy.tiktokcommon.rpcservice;

import com.yzy.tiktokcommon.entity.domain.User;

import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 12:48
 */
public interface RpcUserService {
    List<User> getUserListByIds(List<Long> ids);

    List<User> getFriends(Long userId);

    User getUserById(Long userId);
}

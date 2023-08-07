package com.yzy.tiktokuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.common.ErrorCode;
import com.yzy.tiktokcommon.exception.BusinessException;
import com.yzy.tiktokuser.mapper.UserMapper;
import com.yzy.tiktokuser.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-08-05 21:26:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public Long register(String username, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User one = getOne(wrapper);
        if (one != null) {

        }
        User user = new User(username, password);
        boolean save = save(user);
        if (!save) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "保存失败");
        }

        return getByUserName(username).getId();

    }

    @Override
    public User getByUserName(String username) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    public Long login(String username, String password) {
        User user = getByUserName(username);
        boolean equals = password.equals(user.getPassword());
        if (!equals) {
            return -1L;
        }
        return user.getId();
    }

    @Override
    public User getByUserId(Long userId) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getId, userId));
    }
}





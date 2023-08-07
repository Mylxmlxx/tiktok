package com.yzy.tiktokuser.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yzy.tiktokcommon.entity.domain.User;

/**
* @author Lenovo
* @description 针对表【user】的数据库操作Service
* @createDate 2023-08-05 21:26:37
*/
public interface UserService extends IService<User> {

    Long register(String username, String password);

    User getByUserName(String username);

    Long login(String username, String password);

    User getByUserId(Long userId);

}

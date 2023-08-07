package com.yzy.tiktokuser;

import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokuser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TiktokUserApplicationTests {
    @Resource
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User("yzy", "123");
        userService.save(user);
//        System.out.println(DateUtils.GetNow());
    }

}

package com.yzy.tiktokmessage.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yzy.tiktokcommon.entity.domain.Message;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【message】的数据库操作Service
* @createDate 2023-08-05 21:26:37
*/
public interface MessageService extends IService<Message> {

    void sendMessage(long fromUserId, long toUserId, String content);

    List<Message> getChatList(long fromUserId, long toUserId);

}

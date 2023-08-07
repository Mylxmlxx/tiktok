package com.yzy.tiktokmessage.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.xml.internal.ws.api.server.LazyMOMProvider;
import com.yzy.tiktokcommon.entity.domain.Message;
import com.yzy.tiktokmessage.mapper.MessageMapper;
import com.yzy.tiktokmessage.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 * @description 针对表【message】的数据库操作Service实现
 * @createDate 2023-08-05 21:26:37
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
        implements MessageService {

    @Override
    public void sendMessage(long fromUserId, long toUserId, String content) {
        Message message = new Message();
        message.setContent(content);
        message.setToUserId(toUserId);
        message.setFromUserId(fromUserId);
        save(message);
    }

    @Override
    public List<Message> getChatList(long fromUserId, long toUserId) {
        List<Message> list = list();
        List<Message> messages = list.stream().filter(message -> (message.getFromUserId() == fromUserId && message.getToUserId() == toUserId)
                || message.getFromUserId() == toUserId && message.getToUserId() == fromUserId).collect(Collectors.toList());

        messages.sort((o1, o2) -> (int) (o1.getCreatedAt() - o2.getCreatedAt()));

        return messages;
    }
}





package com.yzy.tiktokmessage.controller;

import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.entity.domain.Message;
import com.yzy.tiktokcommon.entity.request.message.ChatListRequest;
import com.yzy.tiktokcommon.entity.request.message.SendMessageRequest;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import com.yzy.tiktokmessage.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 18:59
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    MessageService messageService;

    /**
     * 发送消息
     *
     * @param request
     * @return
     */
    @PostMapping("/action")
    public BaseResponse sendMessage(@RequestBody SendMessageRequest request) {

        long fromUserId = Long.parseLong(TokenUtil.checkToken(request.getToken()));
        long toUserId = Long.parseLong(request.getUserId());
        String content = request.getContent();
        // TODO ? 有啥用
        String actionType = request.getActionType();
        messageService.sendMessage(fromUserId, toUserId, content);
        return ResultUtils.success("ok");

    }

    /**
     * 聊天记录
     *
     * @param request
     * @return
     */
    @GetMapping("/chat")
    public BaseResponse<List<Message>> chatList(ChatListRequest request) {
        long fromUserId = Long.parseLong(TokenUtil.checkToken(request.getToken()));
        long toUserId = Long.parseLong(request.getToUserId());

        List<Message> list = messageService.getChatList(fromUserId, toUserId);

        return ResultUtils.success(list);
    }
}
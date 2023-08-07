package com.yzy.tiktokcomment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.tiktokcommon.entity.domain.Comment;
import com.yzy.tiktokcomment.service.CommentService;
import com.yzy.tiktokcomment.mapper.CommentMapper;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.entity.response.CommentResponse;
import com.yzy.tiktokcommon.rpcservice.RpcUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 * @description 针对表【comment】的数据库操作Service实现
 * @createDate 2023-08-06 20:38:20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {

    @DubboReference
    RpcUserService rpcUserService;

    @Override
    public CommentResponse action(long fromUserId, long videoId, String content, String actionType, long commentId) {
        if (!actionType.equals("1")) {
            removeById(commentId);
            CommentResponse response = new CommentResponse();
            response.setContent(getById(commentId).getContent());
            Long userId = getById(commentId).getUserId();
            User user = rpcUserService.getUserById(userId);
            response.setUser(user);
            return response;
        }

        CommentResponse response = new CommentResponse();
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserId(fromUserId);
        comment.setVideoId(videoId);
        save(comment);

        response.setContent(content);
        response.setUser(rpcUserService.getUserById(fromUserId));

        return response;
    }

    @Override
    public List<CommentResponse> getCommentList(long videoId) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getVideoId, videoId);
        List<Comment> list = list(wrapper);
        List<CommentResponse> responseList = list.stream().map(one -> {
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setContent(one.getContent());
            commentResponse.setUser(rpcUserService.getUserById(one.getUserId()));
            return commentResponse;
        }).collect(Collectors.toList());
        return responseList;
    }
}





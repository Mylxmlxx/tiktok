package com.yzy.tiktokcomment.service;

import com.yzy.tiktokcommon.entity.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzy.tiktokcommon.entity.response.CommentResponse;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-08-06 20:38:20
*/
public interface CommentService extends IService<Comment> {

    CommentResponse action(long fromUserId, long videoId, String content, String actionType, long commentId);

    List<CommentResponse> getCommentList(long videoId);
}

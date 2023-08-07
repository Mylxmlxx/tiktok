package com.yzy.tiktokcomment.controller;

import com.yzy.tiktokcomment.service.CommentService;
import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.entity.request.comment.CommentActionRequest;
import com.yzy.tiktokcommon.entity.request.comment.CommentListRequest;
import com.yzy.tiktokcommon.entity.response.CommentResponse;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 20:40
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    /**
     * 评论操作
     *
     * @param request
     * @return
     */
    @PostMapping("/action")
    public BaseResponse<CommentResponse> action(@RequestBody CommentActionRequest request) {
        long fromUserId = Long.parseLong(TokenUtil.checkToken(request.getToken()));
        long videoId = Long.parseLong(request.getVideoId());
        String content = request.getContent();
        String actionType = request.getActionType();
        long commentId = Long.parseLong(request.getCommentId());

        CommentResponse response = commentService.action(fromUserId, videoId, content, actionType, commentId);
        return ResultUtils.success(response);
    }

    /**
     * 评论列表
     *
     * @param request
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<CommentResponse>> getCommentList(CommentListRequest request) {
        TokenUtil.checkToken(request.getToken());

        long videoId = Long.parseLong(request.getVideoId());
        List<CommentResponse> list = commentService.getCommentList(videoId);

        return ResultUtils.success(list);
    }
}

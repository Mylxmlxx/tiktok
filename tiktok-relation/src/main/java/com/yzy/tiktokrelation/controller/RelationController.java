package com.yzy.tiktokrelation.controller;

import com.auth0.jwt.JWT;
import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.entity.domain.User;
import com.yzy.tiktokcommon.entity.request.realtion.RelationRequest;
import com.yzy.tiktokcommon.entity.request.realtion.FollowRequest;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import com.yzy.tiktokrelation.service.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 9:59
 */
@RestController
@RequestMapping("/relation")
@Slf4j
public class RelationController {
    @Resource
    FollowService followService;

    /**
     * 关注操作
     *
     * @param request
     * @return
     */
    @PostMapping("/action")
    public BaseResponse follow(@RequestBody FollowRequest request) {
        String actionType = request.getActionType();
        String followerId = request.getUserId();
        String token = request.getToken();
        String followId = JWT.decode(token).getAudience().get(0);

        followService.follow(followId, followerId, actionType);
        return ResultUtils.success("ok");
    }

    /**
     * 关注列表
     *
     * @param request
     * @return
     */
    @GetMapping("follow/list")
    public BaseResponse<List<User>> followList(RelationRequest request) {
        TokenUtil.checkToken(request.getToken());
        String userId = request.getUserId();
        List<User> users = followService.followList(userId);
        return ResultUtils.success(users);
    }

    /**
     * 粉丝列表
     *
     * @param request
     * @return
     */
    @GetMapping("follower/list")
    public BaseResponse<List<User>> followerList(RelationRequest request) {
        TokenUtil.checkToken(request.getToken());
        String userId = request.getUserId();
        List<User> users = followService.followerList(userId);
        return ResultUtils.success(users);
    }

    /**
     * 好友列表
     *
     * @param request
     * @return
     */
    @GetMapping("/friend/list")
    public BaseResponse<List<User>> friendList(RelationRequest request) {
        TokenUtil.checkToken(request.getToken());
        List<User> users = followService.getFriendList(request.getUserId());
        return ResultUtils.success(users);
    }
}

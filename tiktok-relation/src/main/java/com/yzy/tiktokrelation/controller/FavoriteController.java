package com.yzy.tiktokrelation.controller;

import com.alibaba.nacos.shaded.org.checkerframework.checker.index.qual.GTENegativeOne;
import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokcommon.entity.request.favorite.FavoriteActionRequest;
import com.yzy.tiktokcommon.entity.request.favorite.FavoriteListRequest;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import com.yzy.tiktokrelation.service.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/6 21:46
 */
@RestController
@RequestMapping("/favorite")
@Slf4j
public class FavoriteController {
    @Resource
    FavoriteService favoriteService;

    /**
     * 赞操作
     *
     * @param request
     * @return
     */
    @PostMapping("/like")
    public BaseResponse like(@RequestBody FavoriteActionRequest request) {
        long userId = Long.parseLong(TokenUtil.checkToken(request.getToken()));
        long videoId = Long.parseLong(request.getVideoId());
        String actionType = request.getActionType();
        favoriteService.action(userId, videoId, actionType);
        return ResultUtils.success("ok");
    }


    /**
     * 喜欢列表
     * @param request
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<Video>> list(FavoriteListRequest request) {
        TokenUtil.checkToken(request.getToken());
        long userId = Long.parseLong(request.getUserId());
        List<Video> list = favoriteService.list(userId);
        return ResultUtils.success(list);
    }
}

package com.yzy.tiktokvideo.controller;

import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokcommon.entity.request.video.FeedRequest;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import com.yzy.tiktokvideo.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/7 16:29
 */
@RequestMapping("/video")
@RestController
public class FeedController {
    @Resource
    private VideoService videoService;

    /**
     * 视频流接口
     *
     * @param request
     * @return
     */
    @GetMapping("/feed")
    public BaseResponse<List<Video>> feed(FeedRequest request) {
        TokenUtil.checkToken(request.getToken());
        long latestTimeStamp = Long.parseLong(request.getLatestTime());
        // 返回latestTimeStamp之前的视频
        List<Video> list = videoService.feed(latestTimeStamp);
        return ResultUtils.success(list);
    }

    /**
     * 视频列表
     *
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<Video>> list() {
        List<Video> list = videoService.list();
        return ResultUtils.success(list);
    }
}

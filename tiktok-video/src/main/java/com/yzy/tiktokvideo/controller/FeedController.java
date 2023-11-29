package com.yzy.tiktokvideo.controller;

import com.yzy.tiktokcommon.common.BaseResponse;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokcommon.entity.request.video.FeedRequest;
import com.yzy.tiktokcommon.utils.ResultUtils;
import com.yzy.tiktokcommon.utils.TokenUtil;
import com.yzy.tiktokvideo.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yzy
 * @version 1.0
 * @description 视频流接口
 * @date 2023/8/7 16:29
 */
@RequestMapping("/video")
@RestController
@Slf4j
public class FeedController {
    @Resource
    private VideoService videoService;

    /**
     * 视频流接口
     *
     * @param request 请求参数
     * @return 视频列表
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


    //upload
    @PostMapping("/upload")
    public void upload(String name, MultipartFile file) throws Exception {
        log.info("name:{}", name);
        log.info("file:{}", file);


    }
}

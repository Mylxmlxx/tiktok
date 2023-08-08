package com.yzy.tiktokvideo.service.rpc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokcommon.rpcservice.RpcVideoService;
import com.yzy.tiktokvideo.service.VideoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/7 16:50
 */
@DubboService
public class OuterVideoService implements RpcVideoService {
    @Resource
    private VideoService videoService;

    @Override
    public List<Video> getVideoList() {
        return videoService.list();
    }

    @Override
    public List<Video> getVideoListByIds(List<Long> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        return videoService.listByIds(ids);
    }
}

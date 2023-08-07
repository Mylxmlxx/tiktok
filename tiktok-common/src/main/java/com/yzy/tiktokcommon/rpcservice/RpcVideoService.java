package com.yzy.tiktokcommon.rpcservice;

import com.yzy.tiktokcommon.entity.domain.Video;

import java.util.List;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/7 16:45
 */
public interface RpcVideoService {
    List<Video> getVideoList();

    List<Video> getVideoListByIds(List<Long> ids);
}

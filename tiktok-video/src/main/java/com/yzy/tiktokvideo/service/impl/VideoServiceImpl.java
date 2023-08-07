package com.yzy.tiktokvideo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokvideo.mapper.VideoMapper;
import com.yzy.tiktokvideo.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lenovo
 * @description 针对表【video】的数据库操作Service实现
 * @createDate 2023-08-07 16:24:47
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
        implements VideoService {

    @Override
    public List<Video> feed(long latestTimeStamp) {
        // 返回latestTimeStamp之前的视频
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        wrapper.lt(Video::getCreatedAt, latestTimeStamp);
        return list(wrapper);
    }
}





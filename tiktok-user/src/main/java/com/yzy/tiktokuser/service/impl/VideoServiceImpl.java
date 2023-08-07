package com.yzy.tiktokuser.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokuser.mapper.VideoMapper;
import com.yzy.tiktokuser.service.VideoService;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【video】的数据库操作Service实现
* @createDate 2023-08-05 21:26:37
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService {

}





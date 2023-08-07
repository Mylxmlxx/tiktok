package com.yzy.tiktokvideo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yzy.tiktokcommon.entity.domain.Video;

import java.util.List;

/**
* @author Lenovo
* @description 针对表【video】的数据库操作Service
* @createDate 2023-08-07 16:24:47
*/
public interface VideoService extends IService<Video> {

    List<Video> feed(long latestTimeStamp);


}

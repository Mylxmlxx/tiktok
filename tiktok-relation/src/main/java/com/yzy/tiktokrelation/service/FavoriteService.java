package com.yzy.tiktokrelation.service;

import com.yzy.tiktokcommon.entity.domain.Favorite;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzy.tiktokcommon.entity.domain.Video;

import java.util.List;

/**
 * @author Lenovo
 * @description 针对表【favorite】的数据库操作Service
 * @createDate 2023-08-06 21:51:32
 */
public interface FavoriteService extends IService<Favorite> {

    void action(long userId, long videoId, String actionType);

    List<Video> list(long userId);
}

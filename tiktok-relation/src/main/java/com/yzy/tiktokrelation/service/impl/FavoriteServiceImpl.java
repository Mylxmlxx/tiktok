package com.yzy.tiktokrelation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.tiktokcommon.entity.domain.Favorite;
import com.yzy.tiktokcommon.entity.domain.Video;
import com.yzy.tiktokcommon.rpcservice.RpcVideoService;
import com.yzy.tiktokrelation.service.FavoriteService;
import com.yzy.tiktokrelation.mapper.FavoriteMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 * @description 针对表【favorite】的数据库操作Service实现
 * @createDate 2023-08-06 21:51:32
 */
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
        implements FavoriteService {

    @DubboReference
    private RpcVideoService rpcVideoService;

    @Override
    public void action(long userId, long videoId, String actionType) {
        LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Favorite::getUserId, userId).eq(Favorite::getVideoId, videoId);
        Favorite one = getOne(wrapper);

        //点赞
        if (one == null && actionType.equals("1")) {
            Favorite favorite = new Favorite();
            favorite.setStatus(1);
            favorite.setVideoId(videoId);
            favorite.setUserId(userId);
            save(favorite);
        }

        if (one != null) {
            one.setStatus(one.getStatus() == 1 ? 0 : 1);
            updateById(one);
        }

    }

    @Override
    public List<Video> list(long userId) {
            LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Favorite::getUserId, userId).eq(Favorite::getStatus, 1);
        List<Long> videoIds = list(wrapper).stream().map(Favorite::getVideoId).collect(Collectors.toList());
        List<Video> videos = rpcVideoService.getVideoListByIds(videoIds);
        return videos;
    }
}





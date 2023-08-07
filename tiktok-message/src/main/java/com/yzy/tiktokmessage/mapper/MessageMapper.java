package com.yzy.tiktokmessage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzy.tiktokcommon.entity.domain.Message;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Lenovo
 * @description 针对表【message】的数据库操作Mapper
 * @createDate 2023-08-05 21:26:37
 * @Entity generator.domain.Message
 */

public interface MessageMapper extends BaseMapper<Message> {

}





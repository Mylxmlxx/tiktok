package com.yzy.tiktokrelation.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/5 22:12
 */
@Component
public class DateConfig implements MetaObjectHandler {
    /**
     * 使用mp做添加操作时候，这个方法执行
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //设置属性值
        this.setFieldValByName("createdAt", new Date().getTime(), metaObject);
        this.setFieldValByName("updatedAt", new Date().getTime(), metaObject);
    }

    /**
     * 使用mp做修改操作时候，这个方法执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedAt", new Date().getTime(), metaObject);
    }
}

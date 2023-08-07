package com.yzy.tiktokcommon.entity.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName message
 */
@TableName(value = "message")
@Data
public class Message implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long createdAt;

    /**
     *
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long updatedAt;

    /**
     *
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long deletedAt;

    /**
     *
     */
    private Long fromUserId;

    /**
     *
     */
    private Long toUserId;

    /**
     *
     */
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
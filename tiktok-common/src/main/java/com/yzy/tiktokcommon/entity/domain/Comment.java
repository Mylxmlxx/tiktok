package com.yzy.tiktokcommon.entity.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName comment
 */
@TableName(value = "comment")
@Data
public class Comment implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private Long videoId;

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private String content;

    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createdAt;

    /**
     *
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedAt;

    /**
     *
     */
    private Long deletedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
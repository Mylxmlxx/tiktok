package com.yzy.tiktokcommon.entity.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName follow
 */
@TableName(value = "follow")
@Data
public class Follow implements Serializable {
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
    private Long followId;

    /**
     *
     */
    private Long followerId;

    /**
     *
     */
    private Integer isFollow;

    /**
     *
     */
    private Integer isMutual;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
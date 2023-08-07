package com.yzy.tiktokcommon.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName video
 */
@TableName(value ="video")
@Data
public class Video implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long createdAt;

    /**
     * 
     */
    private Long updatedAt;

    /**
     * 
     */
    private Long deletedAt;

    /**
     * 
     */
    private Long authorId;

    /**
     * 
     */
    private String playUrl;

    /**
     * 
     */
    private String coverUrl;

    /**
     * 
     */
    private Long favoriteCount;

    /**
     * 
     */
    private Long commentCount;

    /**
     * 
     */
    private String title;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
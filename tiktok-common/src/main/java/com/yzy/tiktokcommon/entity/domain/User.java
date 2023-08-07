package com.yzy.tiktokcommon.entity.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
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
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Integer followCount;

    /**
     *
     */
    private Integer followerCount;

    /**
     *
     */
    private String avatar;

    /**
     *
     */
    private String backgroundImage;

    /**
     *
     */
    private String signature;

    /**
     *
     */
    private Integer totalFavorited;

    /**
     *
     */
    private Integer workCount;

    /**
     *
     */
    private Integer favoriteCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String LongToString(Long userId) {
        return String.valueOf(userId);
    }


}
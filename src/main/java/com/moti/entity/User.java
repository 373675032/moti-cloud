package com.moti.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * (User)用户实体类
 *
 * @author 莫提
 * @since 2020-02-25 17:19:04
 */
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 用户的openid
    */
    private String openId;
    /**
    * 文件仓库ID
    */
    private Integer fileStoreId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 注册时间
    */
    private Date registerTime;
    /**
    * 头像地址
    */
    private String imagePath;

}
package com.moti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: UserToShow
 * @Description: 用于前端显示
 * @author: xw
 * @date 2020/3/10 16:31
 * @Version: 1.0
 **/
@AllArgsConstructor
@Data
@Builder
public class UserToShow {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 头像地址
     */
    private String imagePath;
    /**
     * 当前已使用百分比
     */
    private Integer current;
    /**
     * 仓库最大容量（单位KB）
     */
    private Integer maxSize;
    /**
     * 仓库权限：0可上传下载、1只允许下载、2禁止上传下载
     */
    private Integer permission;
}

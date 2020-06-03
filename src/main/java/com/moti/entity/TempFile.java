package com.moti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TempFile)实体类
 *
 * @author 莫提
 * @since 2020-03-10 11:23:00
 */
@AllArgsConstructor
@Data
@Builder
public class TempFile implements Serializable {
    private static final long serialVersionUID = -90736141035866360L;
    /**
    * 临时文件ID
    */
    private Integer fileId;
    /**
    * 文件名
    */
    private String fileName;
    /**
    * 文件大小
    */
    private String size;
    /**
    * 上传时间：4小时后删除
    */
    private Date uploadTime;
    /**
    * 文件在FTP上的存放路径
    */
    private String filePath;

}
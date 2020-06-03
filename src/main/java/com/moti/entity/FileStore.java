package com.moti.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * (FileStore)文件仓库实体类
 *
 * @author 莫提
 * @since 2020-02-25 17:19:04
 */
@AllArgsConstructor
@Data
@Builder
public class FileStore implements Serializable {

    /**
    * 文件仓库ID
    */
    private Integer fileStoreId;
    /**
    * 主人ID
    */
    private Integer userId;
    /**
    * 当前容量（单位KB）
    */
    private Integer currentSize;
    /**
    * 最大容量（单位KB）
    */
    private Integer maxSize;
    /**
     * 仓库权限：0可上传下载、1只允许下载、2禁止上传下载
     */
    private Integer permission;

}
package com.moti.mapper;

import com.moti.entity.FileFolder;
import com.moti.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName: FileFolderMapper
 * @Description: 与文件夹相关的数据库操作
 * @author: xw
 * @date 2020/1/26 21:55
 * @Version: 1.0
 **/
@Mapper
public interface FileFolderMapper {

    /**
     * @Description 根据文件夹的id删除文件夹
     * @Author xw
     * @Date 15:18 2020/2/26
     * @Param [fileFolderId]
     * @return java.lang.Integer
     **/
    Integer deleteFileFolderById(Integer fileFolderId);

    /**
     * @Description 根据父文件夹的id删除文件夹
     * @Author xw
     * @Date 15:18 2020/2/26
     * @Param [parentFolderId]
     * @return java.lang.Integer
     **/
    Integer deleteFileFolderByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据仓库的id删除文件夹
     * @Author xw
     * @Date 15:18 2020/2/26
     * @Param [fileStoreId]
     * @return java.lang.Integer
     **/
    Integer deleteFileFolderByFileStoreId(Integer fileStoreId);

    /**
     * @Description 增加文件夹
     * @Author xw
     * @Date 15:18 2020/2/26
     * @Param [fileFolder]
     * @return java.lang.Integer
     **/
    Integer addFileFolder(FileFolder fileFolder);

    /**
     * @Description 根据文件夹的id获取文件夹
     * @Author xw
     * @Date 15:18 2020/2/26
     * @Param [fileFolderId]
     * @return com.moti.entity.FileFolder
     **/
    FileFolder getFileFolderById(Integer fileFolderId);

    /**
     * @Description 根据父文件夹的id获取文件夹
     * @Author xw
     * @Date 15:18 2020/2/26
     * @Param  * @param null
     * @return
     **/
    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId);

    /**
     * @Description 根据仓库的id获取文件夹
     * @Author xw
     * @Date 15:19 2020/2/26
     * @Param [fileStoreId]
     * @return java.util.List<com.moti.entity.FileFolder>
     **/
    List<FileFolder> getFileFolderByFileStoreId(Integer fileStoreId);
    
    /**
     * @Description 获得仓库的文件夹数量
     * @Author xw
     * @Date 21:56 2020/2/10
     * @Param [fileStoreId]
     * @return java.lang.Integer
     **/
    Integer getFileFolderCountByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author xw
     * @Date 23:49 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.FileFolder>
     **/
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId);

    /**
     * @Description 根据文件夹的id修改文件夹信息
     * @Author xw
     * @Date 15:19 2020/2/26
     * @Param [fileFolder]
     * @return java.lang.Integer
     **/
    Integer updateFileFolderById(FileFolder fileFolder);

    /**
     * @Description 根据文件夹的id获取文件夹下面的文件
     * @Author xw
     * @Date 15:19 2020/2/26
     * @Param [fileStoreId]
     * @return java.util.List<com.moti.entity.MyFile>
     **/
    List<MyFile> getFileByFileFolder(Integer fileStoreId);

}
package com.moti.mapper;

import com.moti.entity.FileStoreStatistics;
import com.moti.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName: MyFileMapper
 * @Description: 与文件相关的数据库操作
 * @author: xw
 * @date 2020/1/26 21:55
 * @Version: 1.0
 **/
@Mapper
public interface MyFileMapper {

    /**
     * @Description 添加文件
     * @Author xw
     * @Date 15:20 2020/2/26
     * @Param [myFile]
     * @return java.lang.Integer
     **/
    Integer addFileByFileStoreId(MyFile myFile);

    /**
     * @Description 根据文件id修改文件
     * @Author xw
     * @Date 15:20 2020/2/26
     * @Param [myFile]
     * @return java.lang.Integer
     **/
    Integer updateFileByFileId(MyFile myFile);

    /**
     * @Description 根据文件的id删除文件
     * @Author xw
     * @Date 15:20 2020/2/26
     * @Param [myFileId]
     * @return java.lang.Integer
     **/
    Integer deleteByFileId(Integer myFileId);

    /**
     * @Description 根据父文件夹的id删除文件
     * @Author xw
     * @Date 15:20 2020/2/26
     * @Param [id]
     * @return java.lang.Integer
     **/
    Integer deleteByParentFolderId(Integer id);

    /**
     * @Description 根据文件的id获取文件
     * @Author xw
     * @Date 15:20 2020/2/26
     * @Param [myFileId]
     * @return com.moti.entity.MyFile
     **/
    MyFile getFileByFileId(Integer myFileId);

    /**
     * @Description 获得仓库根目录下的所有文件
     * @Author xw
     * @Date 23:53 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.MyFile>
     **/
    List<MyFile> getRootFilesByFileStoreId(Integer fileStoreId);
    
    /**
     * @Description 根据父文件夹id获得文件 
     * @Author xw
     * @Date 0:07 2020/2/10
     * @Param [parentFolderId]
     * @return java.util.List<com.molihub.entity.MyFile>
     **/
    List<MyFile> getFilesByParentFolderId(Integer parentFolderId);
    
    /**
     * @Description 根据类别获取文件
     * @Author xw
     * @Date 10:13 2020/2/26
     * @Param [storeId, type]
     * @return java.util.List<com.moti.entity.MyFile>
     **/
    List<MyFile> getFilesByType(Integer storeId,Integer type);

    /**
     * @Description 获取仓库的统计信息
     * @Author xw
     * @Date 21:47 2020/2/10
     * @Param [id]
     * @return com.molihub.entity.FileStoreStatistics
     **/
    FileStoreStatistics getCountStatistics(Integer id);
}
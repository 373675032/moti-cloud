package com.moti.service.impl;

import com.moti.entity.FileStoreStatistics;
import com.moti.entity.MyFile;
import com.moti.service.MyFileService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @ClassName: MyFileServiceImpl
* @Description: TODO
* @author: xw
* @date 2020/2/8 22:49
* @Version: 1.0
**/

@Service
public class MyFileServiceImpl extends BaseService implements MyFileService{

    /**
     * @Description 根据文件的id删除文件
     * @Author xw
     * @Date 2020/2/9 15:49
     * @Param [myFileId]
     * @Return Integer
     */
    @Override
    public Integer deleteByFileId(Integer myFileId) {
        return myFileMapper.deleteByFileId(myFileId);
    }

    /**
     * @Description 根据父文件夹的id删除文件
     * @Author xw
     * @Date 2020/2/9 15:49
     * @Param [id]
     * @Return Integer
     */
    @Override
    public Integer deleteByParentFolderId(Integer id) {
        return myFileMapper.deleteByParentFolderId(id);
    }

    /**
     * @Description 添加文件
     * @Author xw
     * @Date 2020/2/9 15:50
     * @Param [myFile]
     * @Return Integer
     */
    @Override
    public Integer addFileByFileStoreId(MyFile myFile) {
        return myFileMapper.addFileByFileStoreId(myFile);
    }

    /**
     * @Description 根据文件id修改文件
     * @Author xw
     * @Date 2020/2/9 15:55
     * @Param [record]
     * @Return Integer
     */
    @Override
    public Integer updateFile(MyFile myFile) {
        return myFileMapper.updateFileByFileId(myFile);
    }

    /**
     * @Description 获得仓库根目录下的所有文件
     * @Author xw
     * @Date 23:53 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.MyFile>
     **/
    @Override
    public List<MyFile> getRootFilesByFileStoreId(Integer fileStoreId) {
        return myFileMapper.getRootFilesByFileStoreId(fileStoreId);
    }

    /**
     * @Description 根据父文件夹id获得文件
     * @Author xw
     * @Date 0:06 2020/2/10
     * @Param [parentFolderId]
     * @return java.util.List<com.molihub.entity.MyFile>
     **/
    @Override
    public List<MyFile> getFilesByParentFolderId(Integer parentFolderId) {
        return myFileMapper.getFilesByParentFolderId(parentFolderId);
    }

    /**
     * @Description 根据类别获取文件
     * @Author xw
     * @Date 10:13 2020/2/26
     * @Param [storeId, type]
     * @return java.util.List<com.moti.entity.MyFile>
     **/
    @Override
    public List<MyFile> getFilesByType(Integer storeId, Integer type) {
        return myFileMapper.getFilesByType(storeId,type);
    }

    /**
     * @Description 获取仓库的统计信息
     * @Author xw
     * @Date 21:47 2020/2/10
     * @Param [id]
     * @return com.molihub.entity.FileStoreStatistics
     **/
    @Override
    public FileStoreStatistics getCountStatistics(Integer id) {
        FileStoreStatistics statistics = myFileMapper.getCountStatistics(id);
        statistics.setFolderCount(fileFolderMapper.getFileFolderCountByFileStoreId(id));
        return statistics;
    }

    /**
     * @Description 根据文件id获得文件
     * @Author xw
     * @Date 2020/2/9 22:00
     * @Param [myFileId]
     * @Return com.molihub.entity.MyFile
     */
    @Override
    public MyFile getFileByFileId(Integer myFileId) {
        return myFileMapper.getFileByFileId(myFileId);
    }
}

package com.moti.service.impl;

import com.moti.entity.FileFolder;
import com.moti.entity.MyFile;
import com.moti.service.FileFolderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @ClassName: FileFolderServiceImpl
* @Description: TODO
* @author: xw
* @date 2020/2/8 23:00
* @Version: 1.0
**/

@Service
public class FileFolderServiceImpl extends BaseService implements FileFolderService {

    /**
     * @Description 根据文件夹的id删除文件夹
     * @Author xw
     * @Date 2020/2/9 16:38
     * @Param [fileFolderId] 文件夹的id
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.deleteFileFolderById(fileFolderId);
    }

    /**
     * @Description 增加文件夹
     * @Author xw
     * @Date 2020/2/9 16:37
     * @Param [fileFolder] 文件夹对象
     * @Return java.lang.Integer
     */
    @Override
    public Integer addFileFolder(FileFolder fileFolder) {
        return fileFolderMapper.addFileFolder(fileFolder);
    }

    /**
     * @Description 根据文件夹的id获取文件下的文件
     * @Author xw
     * @Date 2020/2/9 16:34
     * @Param [fileFolderId] 文件夹id
     * @Return com.molihub.entity.FileFolder
     */
    @Override
    public List<MyFile> getFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.getFileByFileFolder(fileFolderId);
    }

    /**
     * @Description 根据父文件夹获得所有的文件夹
     * @Author xw
     * @Date 2020/2/9 22:07
     * @Param [parentFolderId]
     * @Return java.util.List<com.molihub.entity.FileFolder>
     */
    @Override
    public Integer updateFileFolderById(FileFolder fileFolder) {
        return fileFolderMapper.updateFileFolderById(fileFolder);
    }

    /**
     * @Description 根据文件夹的id获取文件夹
     * @Author xw
     * @Date 2020/2/9 22:23
     * @Param [fileFolderId]
     * @Return com.molihub.entity.FileFolder
     */
    @Override
    public List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId) {
        return fileFolderMapper.getFileFolderByParentFolderId(parentFolderId);
    }

    /**
     * @Description 根据仓库Id获得仓库根目录下的所有文件夹
     * @Author xw
     * @Date 23:46 2020/2/9
     * @Param [fileStoreId]
     * @return java.util.List<com.molihub.entity.FileFolder>
     **/
    @Override
    public FileFolder getFileFolderByFileFolderId(Integer fileFolderId) {
        return fileFolderMapper.getFileFolderById(fileFolderId);
    }

    /**
     * @Description 根据文件夹的id修改文件夹信息
     * @Author xw
     * @Date 2020/2/9 16:39
     * @Param [fileFolder] 文件夹对象
     * @Return java.lang.Integer
     */
    @Override
    public List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId) {
        return fileFolderMapper.getRootFoldersByFileStoreId(fileStoreId);
    }
}

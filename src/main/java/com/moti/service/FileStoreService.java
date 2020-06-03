package com.moti.service;


import com.moti.entity.FileStore;

/**
 * @InterfaceName: FileStoreService
 * @Description: 文件仓库业务层接口
 * @author: xw
 * @date 2020/1/26 22:15
 * @Version: 1.0
 **/
public interface FileStoreService {

    /**
     * @Description 添加文件仓库（用户注册时调用）
     * @Author xw
     * @Date 21:56 2020/1/26
     * @Param [fileStore]
     * @return java.lang.Integer 返回影响数据库的行数，新增文件仓库id封装在实体类的id属性
     **/
    public Integer addFileStore(FileStore fileStore);

    /**
     * @Description 根据用户id获得文件仓库
     * @Author xw
     * @Date 22:01 2020/1/26
     * @Param [fileStoreId]
     * @return com.molihub.entity.FileStore
     **/
    public FileStore getFileStoreByUserId(Integer userId);

    /**
     * @Description 根据文件仓库id获得文件仓库
     * @Author xw
     * @Date 22:01 2020/1/26
     * @Param [fileStoreId]
     * @return com.molihub.entity.FileStore
     **/
    public FileStore getFileStoreById(Integer fileStoreId);

    /**
     * @Description 修改仓库当前已使用的容量
     * @Author xw
     * @Date 21:18 2020/2/10
     * @Param [id,size]
     * @return java.lang.Integer
     **/
    public Integer addSize(Integer id, Integer size);

    /**
     * @Description 修改仓库当前已使用的容量
     * @Author xw
     * @Date 21:18 2020/2/10
     * @Param [id,size]
     * @return java.lang.Integer
     **/
    public Integer subSize(Integer id, Integer size);

    /**
     * @Description 更新仓库权限
     * @Author xw
     * @Date 16:29 2020/3/10
     * @Param [id, permission]
     * @return java.lang.Integer
     **/
    public Integer updatePermission(Integer id,Integer permission,Integer size);

    /**
     * @Description 通过主键删除仓库
     * @Author xw
     * @Date 20:32 2020/3/10
     * @Param [id]
     * @return java.lang.Integer
     **/
    public Integer deleteById(Integer id);
}

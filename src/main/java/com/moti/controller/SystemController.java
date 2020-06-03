package com.moti.controller;

import com.moti.entity.FileFolder;
import com.moti.entity.FileStoreStatistics;
import com.moti.entity.MyFile;
import com.moti.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SystemController
 * @Description: 系统页面跳转控制器
 * @author: xw
 * @date 2020/2/25 22:02
 * @Version: 1.0
 **/
@Controller
public class SystemController extends BaseController {

    Logger logger = LogUtils.getInstance(SystemController.class);

    /**
     * @return java.lang.String
     * @Description 前往我的网盘
     * @Author xw
     * @Date 23:28 2020/2/10
     * @Param [fId, fName, error, map]
     **/
    @GetMapping("/files")
    public String toFileStorePage(Integer fId, String fName, Integer error, Map<String, Object> map) {
        //判断是否包含错误信息
        if (error != null) {
            if (error == 1) {
                map.put("error", "添加失败！当前已存在同名文件夹");
            }
            if (error == 2) {
                map.put("error", "重命名失败！文件夹已存在");
            }
        }
        //包含的子文件夹
        List<FileFolder> folders = null;
        //包含的文件
        List<MyFile> files = null;
        //当前文件夹信息
        FileFolder nowFolder = null;
        //当前文件夹的相对路径
        List<FileFolder> location = new ArrayList<>();
        if (fId == null || fId <= 0) {
            //代表当前为根目录
            fId = 0;
            folders = fileFolderService.getRootFoldersByFileStoreId(loginUser.getFileStoreId());
            files = myFileService.getRootFilesByFileStoreId(loginUser.getFileStoreId());
            nowFolder = FileFolder.builder().fileFolderId(fId).build();
            location.add(nowFolder);
        } else {
            //当前为具体目录,访问的文件夹不是当前登录用户所创建的文件夹
            FileFolder folder = fileFolderService.getFileFolderByFileFolderId(fId);
            if (folder.getFileStoreId() - loginUser.getFileStoreId() != 0){
                return "redirect:/error401Page";
            }
            //当前为具体目录，访问的文件夹是当前登录用户所创建的文件夹
            folders = fileFolderService.getFileFolderByParentFolderId(fId);
            files = myFileService.getFilesByParentFolderId(fId);
            nowFolder = fileFolderService.getFileFolderByFileFolderId(fId);
            //遍历查询当前目录
            FileFolder temp = nowFolder;
            while (temp.getParentFolderId() != 0) {
                temp = fileFolderService.getFileFolderByFileFolderId(temp.getParentFolderId());
                location.add(temp);
            }
        }
        Collections.reverse(location);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("permission", fileStoreService.getFileStoreByUserId(loginUser.getUserId()).getPermission());
        map.put("folders", folders);
        map.put("files", files);
        map.put("nowFolder", nowFolder);
        map.put("location", location);
        logger.info("网盘页面域中的数据:" + map);
        return "u-admin/files";
    }

    /**
     * @Description 前往文件上传页面
     * @Author xw
     * @Date 15:16 2020/2/26
     * @Param [fId, fName, map]
     * @return java.lang.String
     **/
    @GetMapping("/upload")
    public String toUploadPage(Integer fId, String fName, Map<String, Object> map) {
        //包含的子文件夹
        List<FileFolder> folders = null;
        //当前文件夹信息
        FileFolder nowFolder = null;
        //当前文件夹的相对路径
        List<FileFolder> location = new ArrayList<>();
        if (fId == null || fId <= 0) {
            //代表当前为根目录
            fId = 0;
            folders = fileFolderService.getRootFoldersByFileStoreId(loginUser.getFileStoreId());
            nowFolder = FileFolder.builder().fileFolderId(fId).build();
            location.add(nowFolder);
        } else {
            //当前为具体目录
            folders = fileFolderService.getFileFolderByParentFolderId(fId);
            nowFolder = fileFolderService.getFileFolderByFileFolderId(fId);
            //遍历查询当前目录
            FileFolder temp = nowFolder;
            while (temp.getParentFolderId() != 0) {
                temp = fileFolderService.getFileFolderByFileFolderId(temp.getParentFolderId());
                location.add(temp);
            }
        }
        Collections.reverse(location);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("folders", folders);
        map.put("nowFolder", nowFolder);
        map.put("location", location);
        logger.info("网盘页面域中的数据:" + map);
        return "u-admin/upload";
    }

    /**
     * @Description 前往所有文档页面
     * @Author xw
     * @Date 10:26 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/doc-files")
    public String toDocFilePage( Map<String, Object> map) {
        List<MyFile> files = myFileService.getFilesByType(loginUser.getFileStoreId(),1);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("files", files);
        map.put("permission", fileStoreService.getFileStoreByUserId(loginUser.getUserId()).getPermission());
        return "u-admin/doc-files";
    }

    /**
     * @Description 前往所有图像页面
     * @Author xw
     * @Date 10:26 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/image-files")
    public String toImageFilePage( Map<String, Object> map) {
        List<MyFile> files = myFileService.getFilesByType(loginUser.getFileStoreId(),2);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("files", files);
        map.put("permission", fileStoreService.getFileStoreByUserId(loginUser.getUserId()).getPermission());
        return "u-admin/image-files";
    }

    /**
     * @Description 前往所有视频页面
     * @Author xw
     * @Date 10:26 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/video-files")
    public String toVideoFilePage( Map<String, Object> map) {
        List<MyFile> files = myFileService.getFilesByType(loginUser.getFileStoreId(),3);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("files", files);
        map.put("permission", fileStoreService.getFileStoreByUserId(loginUser.getUserId()).getPermission());
        return "u-admin/video-files";
    }

    /**
     * @Description 前往所有音频页面
     * @Author xw
     * @Date 10:26 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/music-files")
    public String toMusicFilePage( Map<String, Object> map) {
        List<MyFile> files = myFileService.getFilesByType(loginUser.getFileStoreId(),4);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("files", files);
        map.put("permission", fileStoreService.getFileStoreByUserId(loginUser.getUserId()).getPermission());
        return "u-admin/music-files";
    }

    /**
     * @Description 前往其他文件页面
     * @Author xw
     * @Date 10:26 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/other-files")
    public String toOtherFilePage( Map<String, Object> map) {
        List<MyFile> files = myFileService.getFilesByType(loginUser.getFileStoreId(),5);
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("files", files);
        map.put("permission", fileStoreService.getFileStoreByUserId(loginUser.getUserId()).getPermission());
        return "u-admin/other-files";
    }

    /**
     * @Description 登录之后的用户主页
     * @Author xw
     * @Date 10:28 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/index")
    public String index(Map<String, Object> map) {
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        statistics.setFileStore(fileStoreService.getFileStoreById(loginUser.getFileStoreId()));
        map.put("statistics", statistics);
        return "u-admin/index";
    }

    /**
     * @Description 前往帮助页面
     * @Author xw
     * @Date 15:17 2020/2/26
     * @Param [map]
     * @return java.lang.String
     **/
    @GetMapping("/help")
    public String helpPage(Map<String, Object> map) {
        //获得统计信息
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        return "u-admin/help";
    }
}

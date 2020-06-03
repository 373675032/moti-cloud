package com.moti.service.impl;

import com.moti.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: BaseService
 * @Description: TODO
 * @author: xw
 * @date 2020/2/25 17:19
 * @Version: 1.0
 **/
public class BaseService {

    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected MyFileMapper myFileMapper;
    @Autowired
    protected FileFolderMapper fileFolderMapper;
    @Autowired
    protected FileStoreMapper fileStoreMapper;
    @Autowired
    protected TempFileMapper tempFileMapper;
}

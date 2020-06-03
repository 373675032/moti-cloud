package com.moti.controller;

import com.moti.entity.User;
import com.moti.service.*;
import com.moti.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: BaseController
 * @Description: 控制器的基类，所有控制器必须继承此类
 * @author: xw
 * @date 2020/2/25 18:19
 * @Version: 1.0
 **/
public class BaseController {

    @Autowired
    protected UserService userService;
    @Autowired
    protected MyFileService myFileService;
    @Autowired
    protected FileFolderService fileFolderService;
    @Autowired
    protected FileStoreService fileStoreService;
    @Autowired
    protected TempFileService tempFileService;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected User loginUser;

    @Autowired
    protected JavaMailSenderImpl mailSender;
    protected MailUtils mailUtils;

    /**
     * 在每个子类方法调用之前先调用
     * 设置request,response,session这三个对象
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(true);
        loginUser = (User) session.getAttribute("loginUser");
    }
}

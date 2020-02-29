package com.moti.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 登录拦截器:用于登录检查,权限控制
 * @Author xw
 * @Date 15:09 2020/2/26
 * @Param  * @param null
 * @return
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 在目标方式执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            //未登录,返回登录页面
            response.sendRedirect("/moti-cloud/");
            return false;
        }else {
            //已登录,放行
            return true;
        }
    }
}

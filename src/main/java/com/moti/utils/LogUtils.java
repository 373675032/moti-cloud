package com.moti.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 打印日志工具类
 * 单例模式，调用getInstance方式时传入Class参数
 */
public class LogUtils {
    private static Logger logger;
    public static Logger getInstance(Class c){
        return logger =  LoggerFactory.getLogger(c);
    }
    private LogUtils(){}
}

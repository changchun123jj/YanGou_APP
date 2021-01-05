package com.example.demo.util;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 日志控件
 *
 * @author liaoc
 */
public class UtilLog {
    private Logger logger;
    private Class<?> T;

    /**
     * 配置文件路径(当以jar方式发布时，需内部加载配置文件)
     */
    private static URL configUrl;

    /**
     * 构造
     */
    private UtilLog(Class<?> T) {
        super();
        this.T = T;
        this.logger = Logger.getLogger(T);
        //设置log4j配置文件
        if (null == configUrl) {
            configUrl = UtilFile.getResource("/properties/log4j.properties");
        }
        PropertyConfigurator.configure(configUrl);
    }

    /**
     * 获取日志控件实例
     */
    public static UtilLog getInstance(Object obj) {
        UtilLog instance = new UtilLog(obj.getClass());
        return instance;
    }

    /**
     * 获取日志控件实例
     */
    public static UtilLog getInstance(Class<?> T) {
        UtilLog instance = new UtilLog(T);
        return instance;
    }

    /**
     * 打印日志
     *
     * @param msg
     */
    public void debug(Object msg) {
        this.logger.debug(msg);
    }

    /**
     * 打印日志
     *
     * @param msg
     */
    public void info(Object msg) {
        this.logger.info(msg);
    }

    /**
     * 打印日志
     *
     * @param msg
     * @param e
     */
    public void error(Object msg, Exception e) {
        this.logger.error("类" + T.getName() + "发生错误！\r\n异常信息：" + msg, e);
    }

    /**
     * 打印日志
     *
     * @param msg
     * @param t
     */
    public void error(Object msg, Throwable t) {
        this.logger.error("类" + T.getName() + "发生错误！\r\n异常信息：" + msg, t);
    }

    public void error(String message) {
        this.logger.error("类" + T.getName() + "发生错误！\r\n异常信息：" + message);
    }
}

package com.qfann.coder.lister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by qifan on 2018/8/27.
 */
@WebListener
public class CustomLister implements ServletRequestListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("监听器 销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        logger.info("监听器 初始化");
    }
}

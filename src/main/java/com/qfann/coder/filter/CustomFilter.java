package com.qfann.coder.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Created by qifan on 2018/8/27.
 */
@WebFilter(filterName = "customFilter",urlPatterns = {"/**"})
public class CustomFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("dofilter 处理请求");
        //对request、response进行一些预处理
        //设置请求编码
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        //TODO 进行业务逻辑

        //链路 直接传给下一个过滤器
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        logger.info("filter 销毁");
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        filterRegistrationBean.setFilter(customFilter());
        //过滤器名称
        filterRegistrationBean.setName("customFilter");
        //拦截路径
        filterRegistrationBean.addUrlPatterns("/**");
        //设置顺序
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }

    @Bean
    public Filter customFilter(){
        return new CustomFilter();
    }

}

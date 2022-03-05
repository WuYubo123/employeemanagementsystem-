package com.wyb.springboot03web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展SpringMvc

/**
 *
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//实现了视图解析接口的类，就是视图解析类

    //视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");//添加视图控制器，遇到/跳到index
//        registry.addViewController("/index.html").setViewName("index");//添加视图控制器，遇到/跳到index
//        registry.addViewController("/main.html").setViewName("dashboard");//添加视图控制器，遇到/跳到index


    }

    /**
     * 将自定义的国际化配置放到spring容器当中，方式
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}

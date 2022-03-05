package com.wyb.springboot03web.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 顺序非常重要，从下往上
 */
@Configuration
public class ShiroConfig {


    //shiroFilterFactoryBean-------3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //---------------------------------------更改区域-------------

        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/*","authc");//user下的所有人都可以访问
//        filterMap.put("/","authc");

        //授权，正常的情况下，没有权限会跳转到未授权页面
        //只要经过
        filterMap.put("/user/add","perms[user:add]");//可以进行update，但无权限添加
        filterMap.put("/user/update","perms[user:update]");//可以进行update，但无权限添加


        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求，即还没有登录进行登录的页面
        bean.setLoginUrl("/index.html");
        //未授权页面
        bean.setUnauthorizedUrl("/");
//---------------------------------------更改区域-------------
        return bean;
    }

    //添加shiro的内置过滤器
    /*
    anon:无需认证就可以访问
    authc:必须认证了才能访问
    user :必须拥有 记住我 功能才能用
    perms:拥有对某个资源的权限才能访问；
    role:拥有某个角色权限才能访问
     */


    //DafaultWebSecurityManager:-----2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);


        return  securityManager;
    }

    //创建realem对象，需要自定义类------1
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

}

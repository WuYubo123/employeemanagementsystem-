package com.wyb.springboot03web.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取语言参数链接
        String language=request.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就使用默认的
        //如果请求的链接携带了国际化参数
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //国家，地区
            locale=new Locale(split[0], split[1]);

        }


        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

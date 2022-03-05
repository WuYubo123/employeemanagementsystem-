package com.wyb.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/,","/index.html"})//拦截这连个请求
    public String index(){
        return "index";
    }
}

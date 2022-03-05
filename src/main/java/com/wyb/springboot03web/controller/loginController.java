package com.wyb.springboot03web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,HttpSession session){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据 token：令牌
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);//验证密码是否成功

        try {
            subject.login(usernamePasswordToken);//看不到登陆方法，执行了登陆方法
            session.setAttribute("loginUser",username);
            return "emp/list";
        }catch (UnknownAccountException e){//用户名不存在异常
            model.addAttribute("msg","用户名不存在");
            return "index";
        }catch (IncorrectCredentialsException e){//密码不存在
            model.addAttribute("msg","密码错误");
            return "index";
        }

    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        System.out.println("==========================================");
        session.invalidate();
        return "redirect:/index.html";

    }

}

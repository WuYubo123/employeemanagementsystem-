package com.wyb.springboot03web.config;


import com.wyb.springboot03web.pojo.User;
import com.wyb.springboot03web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");
        //授予一定权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//拿到User对象
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());


        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=》认证doGetAuthorizationInfo");
        //全局的关系   userToken中存着前台的用户名密码
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        //链接数据库得用户名密码
        User user = userService.queryUserByName(userToken.getUsername());
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}

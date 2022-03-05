package com.wyb.springboot03web.service;

import com.wyb.springboot03web.mapper.UserMapper;
import com.wyb.springboot03web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}

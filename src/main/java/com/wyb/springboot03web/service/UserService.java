package com.wyb.springboot03web.service;

import com.wyb.springboot03web.pojo.User;

public interface UserService {
    public User queryUserByName(String username);
}

package com.wyb.springboot03web.mapper;

import com.wyb.springboot03web.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public User queryUserByName(String username);
}

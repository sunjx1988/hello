package com.jxsun.mybatis.mapper.gen;

import com.jxsun.mybatis.entity.User;
import com.jxsun.mybatis.entity.UserExample;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
}
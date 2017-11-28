package com.jxsun.mybatis.mapper.custom;

import com.jxsun.mybatis.entity.User;
import com.jxsun.mybatis.mapper.gen.UserMapper;

import java.util.List;

/**
 * Created by sunjx on 2017/11/28.
 */
public interface UserCustomMapper extends UserMapper {

    List<User> list();
}

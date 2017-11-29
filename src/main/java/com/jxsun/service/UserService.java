package com.jxsun.service;

import com.github.pagehelper.PageInfo;
import com.jxsun.mybatis.entity.User;

/**
 * Created by sunjx on 2017/11/29.
 */
public interface UserService {

    PageInfo<User> list(int pageSize , int pageNo);

    void save(User user);
}

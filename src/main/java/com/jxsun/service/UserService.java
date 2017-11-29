package com.jxsun.service;

import com.github.pagehelper.PageInfo;
import com.jxsun.mybatis.entity.User;
import com.jxsun.service.param.QueryUserCondition;

/**
 * Created by sunjx on 2017/11/29.
 */
public interface UserService {

    PageInfo<User> list(int pageSize , int pageNo);

    PageInfo<User> queryByCondition(QueryUserCondition condition);

    void save(User user);
}

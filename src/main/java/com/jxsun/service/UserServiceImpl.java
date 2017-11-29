package com.jxsun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxsun.mybatis.entity.User;
import com.jxsun.mybatis.mapper.custom.UserCustomMapper;
import com.jxsun.service.param.QueryUserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sunjx on 2017/11/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCustomMapper userCustomMapper;

    @Override
    @Transactional(readOnly = true)
    public PageInfo<User> list(int pageSize , int pageNo){
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<User>(userCustomMapper.list());
    }

    @Override
    public void save(User user) {
        userCustomMapper.insert(user);
    }

    @Override
    public PageInfo<User> queryByCondition(QueryUserCondition condition) {
        PageHelper.startPage(condition.getPageNo(),condition.getPageSize());
        return new PageInfo<User>(userCustomMapper.queryByCondition(condition));
    }
}

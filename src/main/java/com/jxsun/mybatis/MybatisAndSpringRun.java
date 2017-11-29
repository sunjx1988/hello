package com.jxsun.mybatis;

import com.jxsun.mybatis.entity.User;
import com.jxsun.mybatis.mapper.custom.UserCustomMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by sunjx on 2017/11/29.
 */
public class MybatisAndSpringRun {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    }

    public static void main(String[] args) {
        UserCustomMapper userMaper = ctx.getBean(UserCustomMapper.class);
        List<User> list = userMaper.list();

        if(list != null){
            for (User user: list) {
                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
                System.out.println(userInfo);
            }
        }
    }

}

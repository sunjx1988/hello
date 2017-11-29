package com.jxsun.mybatis;

import com.github.pagehelper.PageInfo;
import com.jxsun.mybatis.entity.User;
import com.jxsun.mybatis.mapper.custom.UserCustomMapper;
import com.jxsun.service.UserService;
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

//    public static void main(String[] args) {
//        UserCustomMapper userMaper = ctx.getBean(UserCustomMapper.class);
//        List<User> list = userMaper.list();
//
//        if(list != null){
//            for (User user: list) {
//                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
//                System.out.println(userInfo);
//            }
//        }
//    }

    public static void main(String[] args) {
        UserService userService = ctx.getBean(UserService.class);

        //新增用户
        User u = new User();
        u.setDept("开发");
        u.setName("sun");
        u.setPhone("1110");
        u.setWebsite("www.abc.com");
        userService.save(u);

        System.out.println("新用户ID" + u.getId());

        //分页查询
        PageInfo<User> pageInfo = userService.list(2,1);

        System.out.println("\n\n");
        System.out.println("总记录数：" + pageInfo.getTotal());

        if(pageInfo.getList() != null){
            for (User user: pageInfo.getList()) {
                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
                System.out.println(userInfo);
            }
        }

    }

}

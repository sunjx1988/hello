package com.jxsun.mybatis;

import com.github.pagehelper.PageInfo;
import com.jxsun.mybatis.entity.User;
import com.jxsun.service.UserService;
import com.jxsun.service.param.QueryUserCondition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        for (int i = 0; i < 100000; i++) {
            User u = new User();
            u.setDept("开发");
            u.setName("sun" + Math.random());
            u.setPhone("1110");
            u.setWebsite("www.abc.com");
            userService.save(u);
//
            System.out.println("新用户ID: " + u.getId());
        }


        //分页查询
//        PageInfo<User> pageInfo = userService.list(2,1);

        QueryUserCondition condition = new QueryUserCondition();
        condition.setPageSize(1000);
        condition.setLikeName("");
//        condition.setEqName(new String[]{"sun","11"});

        PageInfo<User> pageInfo = userService.queryByCondition(condition);

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

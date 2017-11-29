package com.jxsun.mybatis;

import com.jxsun.mybatis.entity.User;
import com.jxsun.mybatis.mapper.custom.UserCustomMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class Run {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.xml.bak");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        UserCustomMapper mapper = session.getMapper(UserCustomMapper.class);
        try {
//            UserExample example = new UserExample();
//            example.createCriteria().andIdEqualTo(1);
//            User user = mapper.selectByExample(example).get(0);
//
//            if(user!=null){
//                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
//                System.out.println(userInfo);
//            }

            List<User> list = mapper.list();

            if(list != null){
                for (User user: list) {
                    String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
                    System.out.println(userInfo);
                }
            }

        } finally {
            session.close();
        }
    }
}

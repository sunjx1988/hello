package com.jxsun.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/13.
 */
public class ShiroTest {

    Logger logger = LoggerFactory.getLogger(ShiroTest.class);

    /**
     * 简单静态用户密码登录验证
     */
    @Test
    public void test1(){

        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2.得到SecurityManager实例，并绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject并创建验证身份密码token(用户身份凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("sun","jx");

        //4.登录
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            //身份验证失败
            e.printStackTrace();
            logger.debug("身份验证失败");
        }

        //5.断言用户已经登录
//        Assert.assertEquals(true, subject.isAuthenticated());

        //6.登出
//        subject.logout();
    }


    /**
     * realm
     */
    @Test
    public void testRealm(){
        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2.得到SecurityManager实例，并绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject并创建验证身份密码token(用户身份凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("sun","jx1");

        //4.登录
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            //身份验证失败
            e.printStackTrace();
            logger.debug("身份验证失败");
        }
    }

    /**
     * jdbc-realm
     */
    @Test
    public void testJdbcRealm(){
        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2.得到SecurityManager实例，并绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject并创建验证身份密码token(用户身份凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("sun","jx");

        //4.登录
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            //身份验证失败
            e.printStackTrace();
            logger.debug("身份验证失败");
        }
    }

    /**
     * role
     */
    @Test
    public void testRole(){
        //1.登录
        login("classpath:shiro-role.ini" , "sun" ,"jx");

        //2.判断角色拥有权限
        Assert.assertTrue(subject().hasRole("role1"));

        boolean[] hasRoles = subject().hasRoles(Arrays.asList("role1" , "role2" ,"role3"));

        Assert.assertTrue(hasRoles[0]);
        Assert.assertTrue(hasRoles[1]);
//        Assert.assertTrue(hasRoles[2]);

        subject().checkRole("role13");
    }

    /**
     * permission
     */
    @Test
    public void testPermission(){
        //1.登录
        login("classpath:shiro-permission.ini" , "sun" ,"jx");

        //2.判断用户是否有权限 user:create
        Assert.assertTrue(subject().isPermitted("user:create"));

        //3.判断是否有权限 user:create , user:update
        Assert.assertTrue(subject().isPermittedAll("user:create", "user:update"));
    }



    private Subject subject(){
        return SecurityUtils.getSubject();
    }

    private void login(String iniFilePath , String userName , String password){
        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniFilePath);

        //2.得到SecurityManager实例，并绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject并创建验证身份密码token(用户身份凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);

        //4.登录
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            //身份验证失败
            e.printStackTrace();
            logger.debug("身份验证失败");
        }
    }
}

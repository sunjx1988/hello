package com.jxsun.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Administrator on 2017/10/13.
 */
public class MyRealm implements Realm {

    public String getName() {
        return "myRealm";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String passWd = new String((char[]) authenticationToken.getCredentials());

        if(!userName.equals("sun")) {
            throw new UnknownAccountException("未知账号");
        }else if(!passWd.equals("jx")){
            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(userName, passWd , getName());
    }
}

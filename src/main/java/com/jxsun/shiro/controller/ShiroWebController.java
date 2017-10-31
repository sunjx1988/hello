package com.jxsun.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiroWebController {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login/submit", method = RequestMethod.POST)
    @ResponseBody
    public String loginSubmit(){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("sun","jx");
        subject.login(token);

        return "success";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "success";
    }

    @RequestMapping("unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping("authorized")
    public String authorized(){
        return "authorized";
    }
}

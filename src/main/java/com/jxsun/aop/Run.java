package com.jxsun.aop;

import com.jxsun.aop.service.TargetService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunjx on 2017/11/29.
 */
public class Run {

    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext(
                "spring-aop.xml");
    }

    public static void main(String[] args) {
        TargetService targetService = ctx.getBean(TargetService.class);

        targetService.doSomeThing();

//        targetService.throwMethod();
    }
}

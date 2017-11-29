package com.jxsun.aop;

import com.jxsun.aop.service.XmlService;
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
        XmlService xmlService = ctx.getBean(XmlService.class);
        xmlService.doSomeThing();
    }
}

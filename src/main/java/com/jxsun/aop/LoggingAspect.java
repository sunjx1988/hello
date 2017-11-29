package com.jxsun.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by sunjx on 2017/11/29.
 */
@Aspect
public class LoggingAspect {

    @After("@annotation(com.jxsun.aop.LogAble)")
    public void afterLog(){
        System.out.println("after logging ...");
    }

}

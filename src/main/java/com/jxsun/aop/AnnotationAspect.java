package com.jxsun.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by sunjx on 2017/11/29.
 */
@Aspect
public class AnnotationAspect {

    @Pointcut("execution(* com.jxsun.aop.service.*.*(..))")
    public void myPointCut(){}

    @Before("myPointCut()")
    public void before(){
        System.out.println("annotation myPointCut before");
    }
}

package com.hyf.spring4.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author baB_hyf
 * @date 2020/03/03
 */
@Aspect
public class LogAspect {

    @Before("execution(* *(..))")
    public void printBefore(){
        System.out.println("前置通知执行");
    }

    @After("execution(* *(..))")
    public void printAfter(){
        System.out.println("后置通知执行");
    }
}

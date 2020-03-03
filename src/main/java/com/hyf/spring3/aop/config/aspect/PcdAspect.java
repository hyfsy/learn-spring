package com.hyf.spring3.aop.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Aspect
@Component
public class PcdAspect {

//    @Before("execution(* com.hyf.spring3.aop.service..*(..))")
//    private void logPackage(){
//        System.out.println("1. test package deep.");
//    }

//    @Before("this(com.hyf.spring3.aop.service.WorldService)")
//    protected void logThis(){
//        System.out.println("2. test this..");
//    }

//    @Before("target(com.hyf.spring3.aop.service.HelloService)")
//    public void logTarget(){
//        System.out.println("3. test target...");
//    }

//    @Before("args(String, com.hyf.spring3.aop.service.HelloService)")
//    void logArgs(){
//        System.out.println("4. test args....");
//    }

//    @Before("@target(com.hyf.spring3.aop.annotation.PCDA)")
//    public void log_anno_target(){
//        System.out.println("5. test anno target.....");
//    }

//    @Before("@args(.., com.hyf.spring3.aop.annotation.PCDA)")
//    public void log_anno_args(){
//        System.out.println("6. test anno args......");
//    }

//    @Before("@within(com.hyf.spring3.aop.annotation.PCDA)")
//    public void log_anno_within(){
//        System.out.println("7. test anno within.......");
//    }

//    @Before("@annotation(com.hyf.spring3.aop.annotation.PCDA)")
//    public void log_anno_annotation(){
//        System.out.println("8. test anno annotation........");
//    }

//    @Before("bean(*Service*)")
//    public void logBean(){
//        System.out.println("9. test bean.........");
//    }

}

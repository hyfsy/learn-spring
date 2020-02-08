package com.hyf.spring.aop.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyf.spring.aop.annotation.service.AccountServiceImpl;


public class AopAnnotationTest {

    @Test
    public void go(){
        ApplicationContext ioc = new AnnotationConfigApplicationContext(Logger.class);
        AccountServiceImpl accountService = ioc.getBean("accountService", AccountServiceImpl.class);
        accountService.printAccount(11);
    }
}

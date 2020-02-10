package com.hyf.spring.aop.semiauto;

import com.hyf.spring.aop.semiauto.service.IAccountService;
import com.hyf.spring.aop.semiauto.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopSemiTest {

    @Test
    public void go(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-semi-auto.xml");
        IAccountService accountService = ioc.getBean("proxyFactoryBean", IAccountService.class);
        accountService.printAccount(11);
    }

    @Test
    public void go2(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-semi-auto.xml");
        IAccountService accountService = ioc.getBean("accountService", IAccountService.class);
        accountService.printAccount(11);
    }
}

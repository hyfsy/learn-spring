package com.hyf.spring.aop.xml;

import com.hyf.spring.aop.xml.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopXmlTest {

    @Test
    public void go(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop.xml");
        AccountServiceImpl accountService = ioc.getBean("accountService", AccountServiceImpl.class);

        accountService.printAccount(11);
    }
}

package com.hyf.spring.test.annotation.test;

import com.hyf.spring.test.annotation.component.SpringConfiguration;
import com.hyf.spring.test.annotation.pojo.Account;
import com.hyf.spring.test.annotation.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * spring整合单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class TestCRUD {

    @Autowired
    IAccountService accountService;

    @Test
    public void testSelectAllAccount() {
//        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = ioc.getBean("accountService", IAccountService.class);
        List<Account> allAccount = accountService.getAllAccount();
        System.out.println(allAccount);
    }
}

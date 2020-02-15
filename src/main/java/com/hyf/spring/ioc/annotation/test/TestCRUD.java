package com.hyf.spring.ioc.annotation.test;

import com.hyf.spring.ioc.annotation.component.SpringConfiguration;
import com.hyf.spring.ioc.annotation.pojo.Account;
import com.hyf.spring.ioc.annotation.service.IAccountService;
import com.hyf.spring.ioc.annotation.util.CglibProxyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * spring整合单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
@ActiveProfiles("dev")
public class TestCRUD {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private CglibProxyFactory cglibProxyFactory;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSelectAllAccount() {
//        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = ioc.getBean("accountService", IAccountService.class);
        List<Account> allAccount = accountService.getAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void testTransaction() {
        IAccountService cglibProxy = (IAccountService)cglibProxyFactory.getCglibProxy(accountService);
        cglibProxy.transfer(4,5,10.0);
    }

    @Test
    public void testProfile() {
        System.out.println(dataSource.getClass());
    }
}

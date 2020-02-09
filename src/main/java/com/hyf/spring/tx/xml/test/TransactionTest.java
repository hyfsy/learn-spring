package com.hyf.spring.tx.xml.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyf.spring.tx.xml.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:tx.xml")
public class TransactionTest {

    @Autowired
    private  IAccountService accountService;

    @Test
    public void testTransaction() {
        accountService.transfer(4,5,10d);
    }
}

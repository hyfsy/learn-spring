package com.hyf.spring.tx.xml.test;

import com.hyf.spring.tx.xml.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyf.spring.tx.xml.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:tx.xml")
public class TransactionTest {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void testTransaction() {
        accountService.transfer(4,5,10d);
    }

    @Test
    public void testTransactionTemplate() {
        transactionTemplate.execute(new TransactionCallback<Account>() {
            @Override
            public Account doInTransaction(TransactionStatus status) {

                // ... 在事务模板中写入处理逻辑

                return null;
            }
        });
    }
}

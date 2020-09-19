package com.hyf.spring.test;

import com.hyf.spring.ioc.hightest.highimport.selector.service.ImportService;
import com.hyf.spring.test.pojo.Account;
import com.hyf.spring.test.service.ISer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/05/13
 */
public class QueryRunnerTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("test/queryRunner.xml");
        ISer ser = ctx.getBean(ISer.class);
        ser.add(new Account(null, "zs", 3.33d));
    }
}

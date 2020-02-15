package com.hyf.spring.ioc.hightest.highimport.selector.test;

import com.hyf.spring.ioc.hightest.highimport.selector.service.impl.ImportServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class TestImport {

    @Test
    public void testImportSelector() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext("com.hyf.spring.ioc.hightest.highimport.selector.config");
        // @Import需要指定类的全路径
        ImportServiceImpl importServiceImpl = ioc.getBean("com.hyf.spring.ioc.hightest.highimport.selector.service.impl.ImportServiceImpl", ImportServiceImpl.class);
        System.out.println(importServiceImpl);
    }
}

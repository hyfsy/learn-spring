package com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.test;

import com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.service.impl.ImportServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class SpringBeanDefinitionRegistrarTest {

    @Test
    public void testBeanDefinitionRegistrar() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext("com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.config");
        ImportServiceImpl importServiceImpl = ioc.getBean("importServiceImpl", ImportServiceImpl.class);
        System.out.println(importServiceImpl);
    }
}

package com.hyf.spring.lifecycle;

import com.hyf.spring.lifecycle.pojo.User;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorTest {
    @Test
    public void testBeanPostProcessor() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("lifecycle.xml");
        User user = ioc.getBean("user", User.class);
    }
}

/**
 * 自定义后处理对象
 * <p>
 * 所有Bean创建时都会调用，可以通过参数beanName指定某一个才执行
 */
class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("前方法");

        // 返回Bean对象，也可以返回一个代理对象
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后方法");
        return bean;
    }
}
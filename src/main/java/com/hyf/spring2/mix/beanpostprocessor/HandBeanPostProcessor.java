package com.hyf.spring2.mix.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * 该后置处理器通过手动设置的方式
 *
 * @author baB_hyf
 * @date 2020/02/23
 */
public class HandBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("hand before： " + beanName + " -> " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("hand after： " + beanName + " -> " + bean);
        return bean;
    }
}

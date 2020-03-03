package com.hyf.spring2.mix.beanpostprocessor;

import com.hyf.spring2.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 该后置处理器通过自动扫描的方式注册
 *
 * @author baB_hyf
 * @date 2020/02/23
 */
@Component
public class OrderedBeanPostProcessor implements Ordered, BeanPostProcessor {
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("order before");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("order after");
        return bean;
    }

    @Bean
    public User user(){
        return new User();
    }

}

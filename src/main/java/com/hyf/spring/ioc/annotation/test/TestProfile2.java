package com.hyf.spring.ioc.annotation.test;

import com.hyf.spring.ioc.annotation.component.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/17
 */
public class TestProfile2 {

    @Test
    public void testProfile2() {
        // 仅仅创建一个ioc容器
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        // 设置需要激活的环境，在配置类中的@Profile注解就能生效
        ioc.getEnvironment().setActiveProfiles("test", "dev");
        // 注册主配置类
        ioc.register(SpringConfiguration.class);
        // 刷新容器
        ioc.refresh();
    }
}

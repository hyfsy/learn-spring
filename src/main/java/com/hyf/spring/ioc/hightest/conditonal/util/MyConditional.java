package com.hyf.spring.ioc.hightest.conditonal.util;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 自定义条件筛选bean对象
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
public class MyConditional implements Condition {

    /**
     * 是否注册到ioc容器的核心方法
     *
     * @param context  ioc上下文
     * @param metadata
     * @return 返回true表示需要注册到ioc容器中
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取环境对象
        Environment environment = context.getEnvironment();
        // 获取bean对象定义信息的注册器
        BeanDefinitionRegistry registry = context.getRegistry();
        // 获取资源加载器
        ResourceLoader resourceLoader = context.getResourceLoader();
        // 获取ioc容器使用的BeanFactory对象
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 输出所有的环境信息
        if (environment instanceof StandardEnvironment) {
            StandardEnvironment standardEnvironment = (StandardEnvironment) environment;
            Map<String, Object> systemProperties = standardEnvironment.getSystemProperties();
            Map<String, Object> systemEnvironment = standardEnvironment.getSystemEnvironment();
            systemProperties.forEach((k, v) -> System.out.println(k + " -> " + v));
            System.out.println("\n\n\n");
            systemEnvironment.forEach((k, v) -> System.out.println(k + " -> " + v));
        }

        String osName = environment.getProperty("os.name");
        if (osName.contains("Windows")) {
            return true;
        } else if (osName.contains("Linux")) {
            return true;
        }

        return false;
    }

}

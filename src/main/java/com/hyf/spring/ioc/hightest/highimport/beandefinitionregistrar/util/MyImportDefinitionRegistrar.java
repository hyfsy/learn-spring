package com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.util;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * 自定义包扫描
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
public class MyImportDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public static final String DEFAULT_PACKAGE_SPLIT = ",";

    /**
     * AspectJ表达式
     */
    private String expression;

    /**
     * 不加@ComponentScan注解默认扫描的包，多个用[,]分割
     */
    private String defaultScan;

    public MyImportDefinitionRegistrar() {
        try {
            Properties prop = PropertiesLoaderUtils.loadAllProperties("test/import.properties");
            expression = prop.getProperty("import.custom.expression");
            defaultScan = prop.getProperty("import.custom.default.scan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        List<String> basePackages = new ArrayList<>();

        // 1.扫描ComponentScan指定的包路径
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())) {
            Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            basePackages.addAll(Arrays.asList((String[]) attributes.get("basePackages")));
        }

        // 2.扫描没有ComponentScan注解时默认的扫描路径
        if (basePackages.isEmpty() && !StringUtils.isEmpty(defaultScan)) {
            String[] defaultPackages = defaultScan.split(DEFAULT_PACKAGE_SPLIT);
            basePackages.addAll(Arrays.asList(defaultPackages));
        }

        // 3.扫描注解注释类的包路径
        if (basePackages.isEmpty()) {
            try {
                String classPackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
                basePackages.add(classPackage);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // =====开始扫描=====

        // 指定不使用默认的过滤规则
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
        // 获取AspectJ表达式的类型过滤器
        TypeFilter typeFilter = new AspectJTypeFilter(expression, MyImportDefinitionRegistrar.class.getClassLoader());
        // 将类型过滤器添加到扫描器中
        scanner.addIncludeFilter(typeFilter);

        scanner.scan(basePackages.toArray(new String[basePackages.size()]));
    }
}

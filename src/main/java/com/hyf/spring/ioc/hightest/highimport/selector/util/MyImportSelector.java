package com.hyf.spring.ioc.hightest.highimport.selector.util;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class MyImportSelector implements ImportSelector {

    /**
     * AspectJ表达式
     */
    private String expression;

    /**
     * 不加@ComponentScan注解默认扫描的包
     */
    private String defaultScan;

    public MyImportSelector() {
        try {
            Properties prop = PropertiesLoaderUtils.loadAllProperties("test/import.properties");
            expression = prop.getProperty("import.selector.expression");
            defaultScan = prop.getProperty("import.selector.default.scan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 筛选注册 bean
     *
     * @param importingClassMetadata Import注解注释的class
     * @return 返回一个类全路径的集合，表示注册的bean
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        List<String> scanList = new ArrayList<>();

        // 1.获取ComponentScan上定义的包扫描路径
        boolean hasComponentScan = importingClassMetadata.hasAnnotation(ComponentScan.class.getName());
        if (hasComponentScan) {
            Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            // basePackages和value互为别名
            String[] basePackages = (String[]) attributes.get("basePackages");
            scanList.addAll(Arrays.asList(basePackages));
        }

        if (scanList.isEmpty()) {
            // 2.没有定义ComponentScan路径则采用默认自定义路径
            if (!StringUtils.isEmpty(defaultScan)) {
                scanList.add(defaultScan);
            }
        }

        if (scanList.isEmpty()) {
            try {
                // 3.扫描注解注释的类的包路径
                String packageName = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
                scanList.add(packageName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // 开始扫描路径
        // ImportSelector使用此扫描器，并指定不使用默认过滤规则
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

        // 配置AspectJ的过滤规则
        TypeFilter typeFilter = new AspectJTypeFilter(expression, MyImportSelector.class.getClassLoader());
        scanner.addIncludeFilter(typeFilter);

        Set<String> importSet = new HashSet<>();

        // 获取扫描器扫描出来的指定包下的所有BeanDefinition对象加入到新创建的set集合中
        scanList.forEach(basePackage -> scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> importSet.add(beanDefinition.getBeanClassName())));

        return importSet.toArray(new String[importSet.size()]);
    }

}

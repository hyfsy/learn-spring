package com.hyf.spring.ioc.hightest.yml.util;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义yml文件解析工厂
 * <p>
 * 依赖：org.yaml.snakeyaml
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
public class MyPropertySourceFactory implements PropertySourceFactory {

    /**
     * 本质就是将 EncodedResource 对象转化为 PropertySource 返回
     */
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {

        // 创建yaml文件解析工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        // 设置资源文件
        factoryBean.setResources(resource.getResource());
        // 解析后获取资源文件
        Properties properties = factoryBean.getObject();

        return (name != null ? new PropertiesPropertySource(name, properties) : new PropertiesPropertySource(resource.getResource().getFilename(), properties));
    }
}

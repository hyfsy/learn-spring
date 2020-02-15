package com.hyf.spring.ioc.hightest.conditonal.config;


import com.hyf.spring.ioc.hightest.conditonal.util.MyConditional;
import com.hyf.spring.ioc.hightest.yml.util.MyPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 自定义yml文件解析工厂
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Configuration
@PropertySource(value = "classpath:test/jdbc.yml", factory = MyPropertySourceFactory.class)
public class SpringConfiguration {

    @Value("${window.driver}")
    private String driver;

    @Bean
    @Conditional(MyConditional.class)
    public DataSource getDataSource(){
        System.out.println(driver);
        return null;
    }

    @Bean
    @Conditional(MyConditional.class)
    public DataSource getDataSource(@Value("${linux.driver}") String driver){
        System.out.println(driver);
        return null;
    }

}

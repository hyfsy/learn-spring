package com.hyf.spring.ioc.hightest.yml.config;


import com.hyf.spring.ioc.hightest.yml.util.MyPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义yml文件解析工厂
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Configuration
@PropertySource(value = "classpath:test/jdbc.yml", factory = MyPropertySourceFactory.class)
public class SpringConfiguration {

    @Value("${jdbc.mysql.driver}")
    private String driver;

    @Bean
    public void getDataSource(){
        System.out.println(driver);
    }

}

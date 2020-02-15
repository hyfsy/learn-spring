package com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.config;


import com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.util.MyImportDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自定义扫描加入容器的bean
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Configuration
@ComponentScan
//@ComponentScan("com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.service")
@Import(MyImportDefinitionRegistrar.class)
public class SpringConfig {
}

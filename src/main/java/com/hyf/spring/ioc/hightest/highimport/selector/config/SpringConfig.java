package com.hyf.spring.ioc.hightest.highimport.selector.config;


import com.hyf.spring.ioc.hightest.highimport.selector.util.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自定义扫描加入容器的bean
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Configuration
//@ComponentScan
//@ComponentScan("com.hyf.spring.ioc.hightest.highimport.selector.service")
@Import(MyImportSelector.class)
public class SpringConfig {
}

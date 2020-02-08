package com.hyf.spring.ioc.annotation.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

// @Configuration
@ComponentScan("com.hyf.spring.ioc.annotation")
//@ComponentScan({"com.hyf.spring.ioc.annotation", "com.hyf.spring.ioc.annotation.component"})
@Import(JdbcConfiguration.class)
public class SpringConfiguration {

}

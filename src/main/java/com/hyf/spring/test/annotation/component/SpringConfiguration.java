package com.hyf.spring.test.annotation.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Configuration
@ComponentScan("com.hyf.spring.test.annotation")
//@ComponentScan({"com.hyf.spring.test.annotation", "com.hyf.spring.test.annotation.component"})
@Import(JdbcConfiguration.class)
public class SpringConfiguration {

}

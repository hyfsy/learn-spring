package com.hyf.spring3.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Configuration
@ComponentScan("com.hyf.spring3.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {
}

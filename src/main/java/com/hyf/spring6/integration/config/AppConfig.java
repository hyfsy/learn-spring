package com.hyf.spring6.integration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author baB_hyf
 * @date 2020/10/17
 */
@Configuration
@ComponentScan({
        "com.hyf.spring6.integration.email",
		"com.hyf.spring6.integration.cache",
		"com.hyf.spring6.integration.jms",
        "com.hyf.spring6.integration.schedule",
        "com.hyf.spring6.integration.jmx",
        "com.hyf.spring6.integration.remote",
})
@ImportResource("classpath:spring6/app.xml")
public class AppConfig {
}

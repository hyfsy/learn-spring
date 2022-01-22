package com.hyf.spring6.integration.cache;

import com.hyf.spring6.integration.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2022/01/13
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CacheService bean = context.getBean(CacheService.class);

        bean.testCacheable3(123);
        bean.testCacheable3(123);

        // bean.testCacheable();
        // bean.testCacheable();
        // bean.testCacheable2(111);

    }
}

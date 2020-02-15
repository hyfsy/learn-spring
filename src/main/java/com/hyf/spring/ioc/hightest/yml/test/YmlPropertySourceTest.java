package com.hyf.spring.ioc.hightest.yml.test;

import com.hyf.spring.ioc.hightest.yml.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class YmlPropertySourceTest {

    @Test
    public void testAnalysisYml() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println();
    }
}

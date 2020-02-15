package com.hyf.spring.ioc.hightest.conditonal.test;

import com.hyf.spring.ioc.hightest.conditonal.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class ConditionTest {

    @Test
    public void testConditional() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println();
    }
}

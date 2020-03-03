package com.hyf.spring3.test;

import com.hyf.spring3.aop.config.AspectConfig;
import com.hyf.spring3.aop.service.JpService;
import com.hyf.spring3.aop.service.Sample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
public class ParamsTest {

    @Test
    public void testAdviceJpArgs() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        JpService jpService = context.getBean("jpService", JpService.class);
        String rtnValue = jpService.getString();
        System.out.println(rtnValue);
        jpService.throwException();
    }

    @Test
    public void testCollectionParams() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        Sample sample = context.getBean("sample", Sample.class);
        System.out.println(sample);
        sample.sampleGenericMethod("ceshi");
        sample.sampleGenericCollectionMethod(Arrays.asList(null,null));
    }

}

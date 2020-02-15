package com.hyf.spring.ioc.hightest.typefilter.test;

import com.hyf.spring.ioc.hightest.typefilter.config.SpringConfig;
import com.hyf.spring.ioc.hightest.typefilter.service.DistrictService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class TestTypeFilter {

    @Test
    public void testTypeFilter() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        DistrictService districtService = ioc.getBean("districtService", DistrictService.class);
        System.out.println(districtService);
    }
}

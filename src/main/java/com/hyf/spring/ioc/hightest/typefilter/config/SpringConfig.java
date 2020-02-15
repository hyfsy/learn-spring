package com.hyf.spring.ioc.hightest.typefilter.config;

import com.hyf.spring.ioc.hightest.typefilter.MyTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * 自定义过滤的类别算是排除类别
 * 包含没有排除其他属性的作用
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Component
@ComponentScan(value = "com.hyf.spring.ioc.hightest.typefilter", excludeFilters = @ComponentScan.
        Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class))
public class SpringConfig {
}

package com.hyf.spring.ioc.hightest.typefilter.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 判断区域的注解
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface District {
    String value();
}

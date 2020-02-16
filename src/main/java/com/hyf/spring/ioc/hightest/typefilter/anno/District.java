package com.hyf.spring.ioc.hightest.typefilter.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 判断区域的注解
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface District {
    String value();
}

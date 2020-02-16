package com.hyf.spring.aop.hightest.declareparents.util;

import com.hyf.spring.aop.hightest.declareparents.service.AnimalService;
import com.hyf.spring.aop.hightest.declareparents.service.impl.AnimalServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2020/02/16
 */
@Component
@ComponentScan("com.hyf.spring.aop.hightest.declareparents")
@EnableAspectJAutoProxy
@Aspect
public class DeclareParentAspect {

    /**
     * 建立一个代理类同时代理 PersonService 和 AnimalService，PersonService为主，能转换，反之则不可以
     * <p>
     * value：表示对PersonService及其子类、实现进行增强，[+]表示 及子类、实现
     * 程序执行时 PersonService 可以转换为 AnimalService ，因为生成的代理类包含了这两个接口
     * 但是 AnimalService 不能转换为 PersonService ，因为此处没有声明 AnimalService 的增强子类
     * <p>
     * defaultImpl：设置当前成员变量的默认实现类
     */
    @DeclareParents(value = "com.hyf.spring.aop.hightest.declareparents.service.PersonService+", defaultImpl = AnimalServiceImpl.class)
    private AnimalService animalService;

    @Pointcut("execution(* com.hyf.spring.aop.hightest.declareparents.service..*.*(..))")
    public void pc1() {
    }

}

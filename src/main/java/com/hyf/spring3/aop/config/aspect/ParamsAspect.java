package com.hyf.spring3.aop.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Aspect
@Component
public class ParamsAspect {

    //==============================jp=============================

    @AfterReturning(value = "execution(* *(..))", returning = "o")
    public void returnArgsTest(Integer o){
        System.out.println("has return args: " + o);
    }

    @AfterThrowing(value = "execution(* *(..))", throwing = "e")
    public void exceptionTest(JoinPoint jp, IllegalArgumentException e){
        System.out.println();
        System.out.println("class -> " + jp.getClass());
        System.out.println("shortString -> " + jp.toShortString());
        System.out.println("longString -> " + jp.toLongString());
        System.out.println("jp.toString -> " + jp);
        System.out.println("this -> " + jp.getThis().getClass());
        System.out.println("target -> " + jp.getTarget().getClass());
        System.out.println("*staticPart -> " + jp.getStaticPart());
        System.out.println("*sourceLocation -> " + jp.getSourceLocation());
        System.out.println("signature -> " + jp.getSignature());
        System.out.println("kind -> " + jp.getKind());
        System.out.println("args -> " + Arrays.asList(jp.getArgs()));
        System.out.println("has exception args: " + e);
    }


    //=============================params==========================


    /**
     * 通过绑定形式的PCD定义获取参数值
     * args()中为String类型无效
     */
    @Before(value = "execution(* *(..)) && args(str)")
    public void testOneParams(String str) {
        System.out.println(str);
    }

    @Before("execution(* *..Sample+.sampleGenericMethod(*)) && args(param)")
    public void beforeSampleMethod(String param) {
        System.out.println("paramsAspect.param -> " + param);
    }

    @Before("execution(* *..Sample+.sampleGenericCollectionMethod(*)) && args(param)")
    public void beforeSampleMethod(Collection<String> param) {
        System.out.println("paramsAspect.collection -> " + param);
    }

    @Before("execution(* *cMethod(..)) && args(params)")
    public void beforeOneParamsWithJp(JoinPoint jp, String params){
        System.out.println(jp);
        System.out.println(params);
    }
}

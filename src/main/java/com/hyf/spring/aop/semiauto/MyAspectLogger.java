package com.hyf.spring.aop.semiauto;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类
 * <p>
 * MethodInterceptor 环绕通知
 */
public class MyAspectLogger implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object rtnValue = null;

        try {
            System.out.println("前置通知");

            rtnValue = invocation.proceed();

            System.out.println("后置通知");
        } catch (Throwable t) {
            // 不用Throwable抓不住
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }

        return rtnValue;
    }
}

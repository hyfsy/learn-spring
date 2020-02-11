package com.hyf.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    /**
     * 四种通知都可以加上 #{@link org.aspectj.lang.JoinPoint} 参数
     * <p>
     * 后置通知 额外可加 #{@link Object} 参数表示被代理对象的返回结果
     * <p>
     * 异常通知 额外可加 #{@link Throwable} 参数表示执行方法时抛出的异常对象
     */
    public void loggerBefore(JoinPoint joinPoint) {
        System.out.println("前置通知loggerBefore执行...");
    }

    public void loggerAfterReturning(Object rtnObject) {
        System.out.println("后置通知loggerAfterReturning执行..." + rtnObject);
    }

    public void loggerAfterThrowing(Throwable t) {
        System.out.println("异常通知loggerAfterThrowing执行..." + t);
    }

    public void loggerAfter() {
        System.out.println("最终通知loggerAfter执行...");
    }

    /**
     * 环绕通知问题:
     * <p>
     * 分析：
     * 当我们配置了环绕通知之后,切入点方法没有执行,而通知方法执行了。
     * 通过对比动态代理中的环绕通知代码,发现动态代理的环绕通知有明确的切入点方法调用,而我们的代码中没有。
     * <p>
     * 解决：
     * Spring框架为我们提供了一个接口: ProceedingJoinPoint,该接口有一个方法proceed(),此方法就相当于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数,在程序执行时, spring框架会为我们提供该接口的实现类供我们使用。
     * <p>
     * Spring中的环绕通知:它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    public Object loggerAround(ProceedingJoinPoint pjp) {
        Object rtnValue = null;
        try {
            System.out.println("环绕通知loggerAround方法执行...前置通知");

            Object[] args = pjp.getArgs(); // 获取方法的参数值
            rtnValue = pjp.proceed(args);// 调用业务层方法，即切入点方法

            System.out.println("环绕通知loggerAround方法执行...后置通知");
        } catch (Throwable t) {
            System.out.println("环绕通知loggerAround方法执行...异常通知");
            throw new RuntimeException(t);
        } finally {
            System.out.println("环绕通知loggerAround方法执行...最终通知");
        }
        return rtnValue;
    }
}

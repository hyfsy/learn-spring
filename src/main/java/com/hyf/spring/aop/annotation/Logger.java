package com.hyf.spring.aop.annotation;

import com.hyf.spring.aop.annotation.service.AccountServiceImpl;
import com.hyf.spring.ioc.generic.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import(AccountServiceImpl.class)
@Aspect
public class Logger {

    @Pointcut("execution(* com.hyf.spring.aop.annotation.service.*.*(..))")
    public void pc1() {
    }

    @Before("pc1()")
    public void loggerBefore() {
        System.out.println("前置通知loggerBefore执行...");
    }

    @AfterReturning(value = "pc1()", returning = "rtnObject")
    public void loggerAfterReturning(Object rtnObject) {
        System.out.println("后置通知loggerAfterReturning执行..." + rtnObject);
    }

    @AfterThrowing("pc1()")
    public void loggerAfterThrowing() {
        System.out.println("异常通知loggerAfterThrowing执行...");
    }

    @After("pc1()")
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
    @Around("pc1()")
    public Object loggerAround(ProceedingJoinPoint pjp) {
        Object rtnValue = null;
        try {
            System.out.println("环绕通知loggerAround方法执行...前置通知");

            Object[] args = pjp.getArgs(); // 获取方法的参数值
            rtnValue = pjp.proceed(args);// 调用业务层方法，即切入点方法

            System.out.println("环绕通知loggerAround方法执行...后置通知");
        } catch (Throwable t) {
            System.out.println("环绕通知loggerAround方法执行...异常通知");
        } finally {
            System.out.println("环绕通知loggerAround方法执行...最终通知");
        }
        return rtnValue;
    }

    /**
     * 切入点表达式的argNames也可以不指定，四（三）个的名称必须都一致
     * <p>
     * 指定参数后，其他没有参数的通知方法就不匹配了
     * <p>
     * 使用 &&、||、!、三种运算符来组合切点表达式，表示与或非的关系
     */
    @Pointcut(value = "execution(* com.hyf.spring.aop.annotation.service..*.*(..)) && args(user)", argNames = "user")
    public void testArgNames(User user) {
    }

    @Before("testArgNames(user)")
    public void targetMethod(User user) {
        System.out.println(user);
    }
}

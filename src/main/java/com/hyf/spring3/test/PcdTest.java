package com.hyf.spring3.test;

import com.hyf.spring3.aop.annotation.PCDA;
import com.hyf.spring3.aop.config.AspectConfig;
import com.hyf.spring3.aop.service.HelloService;
import com.hyf.spring3.aop.service.WorldService;
import com.hyf.spring3.aop.service.impl.HelloServiceImplAbstract;
import com.hyf.spring3.aop.service.impl.child.HelloServiceImplAbstractChild;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
public class PcdTest {

    @Test
    public void testAopAnnoHello() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        HelloService helloService = context.getBean("helloService", HelloService.class);
        HelloService helloService2 = context.getBean("helloService2", HelloService.class);
        WorldService worldService = context.getBean("worldService", WorldService.class);
        HelloServiceImplAbstract helloServiceImplAbstractChild = context.getBean("helloServiceChild", HelloServiceImplAbstract.class);

        System.out.println(helloService.getClass());
        System.out.println(helloService2.getClass());
        System.out.println(worldService.getClass());
        System.out.println(helloServiceImplAbstractChild.getClass());
        helloService.say();
        helloService2.say();
        worldService.say();
        worldService.world("asdf", helloService);
        worldService.sayAnn(helloService.getClass().getAnnotation(PCDA.class));
        worldService.sayAnn2(null, null);

    }

    @Test
    public void testCGLIB() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        HelloServiceImplAbstract helloServiceImplAbstractChild = context.getBean("helloServiceChild", HelloServiceImplAbstract.class);
        ((HelloServiceImplAbstractChild) helloServiceImplAbstractChild).noOverride();
        helloServiceImplAbstractChild.say();
        helloServiceImplAbstractChild.overrideMethod();
    }
}

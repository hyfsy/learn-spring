package com.hyf.spring4.test;

import com.hyf.spring4.aspectj.LogAspect;
import com.hyf.spring4.service.ProxyUseService;
import com.hyf.spring4.service.impl.ProxyUseServiceImpl;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author baB_hyf
 * @date 2020/03/03
 */
public class AspectJProxyTest {

    @Test
    public void testCreateProxy() {
        // 创建代理工厂，放入目标对象实例
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(new ProxyUseServiceImpl());
        // 设置代理的接口
//        aspectJProxyFactory.addInterface(AnotherService.class);
        // 放入切面类或对象
        aspectJProxyFactory.addAspect(LogAspect.class);
        ProxyUseService proxy = aspectJProxyFactory.getProxy();
        proxy.speak();
//        AnotherService proxy = aspectJProxyFactory.getProxy();
//        proxy.anotherSay();
    }

    @Test
    public void testAnotherProxy() {
        ProxyFactory proxyFactory = new ProxyFactory(new ProxyUseServiceImpl());
        proxyFactory.addInterface(ProxyUseService.class);
//        proxyFactory.addAdvice();
        // 设置是否使用该代理对象时，将该代理对象与当前线程绑定
        proxyFactory.setExposeProxy(true);
        ProxyUseService proxy = (ProxyUseService)proxyFactory.getProxy();
        proxy.speak();
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.setSingleton(true);
//        factoryBean.setTarget();
    }
}

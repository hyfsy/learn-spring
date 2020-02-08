package com.hyf.spring.test.annotation.util;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

@Component
public class CglibProxyFactory
{

    @Autowired
    private TransactionManager manager;

    /**
     * 获取代理对象
     * @param original 代理对象必须为final类型
     * @return
     */
    public Object getCglibProxy(final Object original) {
        return Enhancer.create(original.getClass(), new MethodInterceptor()
        {
            /**
             *
             * @param o 代理对象的引用
             * @param method 当前执行的方法
             * @param objects 方法所需参数
             * @param methodProxy 当前执行方法的代理对象
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object rtnValue = null;
                try {
                    manager.beginTransaction();
                    rtnValue = method.invoke(original, objects);
                    manager.commit();
                }catch (Exception e) {
                    manager.rollback();
                    throw new RuntimeException(e);
                }finally {
                    manager.close();
                }
                return rtnValue;
            }
        });
    }

}

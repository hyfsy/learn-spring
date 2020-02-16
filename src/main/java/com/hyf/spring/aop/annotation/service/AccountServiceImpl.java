package com.hyf.spring.aop.annotation.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountServiceImpl {

    public void printAccount(Integer money){
        System.out.println("print account: " + money);
//        int i = 1/0;
    }

    /**
     * printAccount() 符合切入点表达式
     * print() 方法不符合切入点表达式
     * 则调用print()方法中的printAccount()不会被增强
     * 此时就需要获取当前线程绑定的代理对象，前提要在@EnableAspectJAutoProxy注解中设置exposeProxy=true
     */
    public void print(){
        AccountServiceImpl accountService = (AccountServiceImpl)AopContext.currentProxy();
        accountService.printAccount(10);
    }
}

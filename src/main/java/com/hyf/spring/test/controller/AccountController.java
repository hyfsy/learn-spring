package com.hyf.spring.test.controller;

import com.hyf.spring.test.BeanFactory;
import com.hyf.spring.test.service.IAccountService;
import com.hyf.spring.test.service.impl.AccountServiceImpl;

public class AccountController
{

    public static void  main(String[] args) {

        // 由我们手动创建对象
        // IAccountService accountService = new AccountServiceImpl();
        // 将自己创建对象的权利交由框架帮助我们创建，转移了创建对象的控制权

        // 由容器帮我们创建对象
        IAccountService accountService = (IAccountService)BeanFactory.getBean("accountService");
        accountService.getAllAccount();
    }
}

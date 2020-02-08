package com.hyf.spring.aop.annotation.service;

import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountServiceImpl {

    public void printAccount(Integer money){
        System.out.println("print account: " + money);
//        int i = 1/0;
    }
}

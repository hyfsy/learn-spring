package com.hyf.spring.aop.xml.service;

public class AccountServiceImpl {

    public String printAccount(Integer money){
        System.out.println("print account: " + money);
        int i = 1/0;
        return "测试beforeReturning的返回值";
    }
}

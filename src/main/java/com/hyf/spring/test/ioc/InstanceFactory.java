package com.hyf.spring.test.ioc;

public class InstanceFactory {

    public Account getAccount(){
        return new Account();
    }
}

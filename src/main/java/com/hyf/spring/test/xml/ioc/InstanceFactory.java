package com.hyf.spring.test.xml.ioc;

public class InstanceFactory {

    public Account getAccount(){
        return new Account();
    }
}

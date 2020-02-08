package com.hyf.spring.test.ioc;

public class StaticFactory {

    public static Account getAccount(){
        return new Account();
    }
}

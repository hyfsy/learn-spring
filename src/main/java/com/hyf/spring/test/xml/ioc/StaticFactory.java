package com.hyf.spring.test.xml.ioc;

public class StaticFactory {

    public static Account getAccount(){
        return new Account();
    }
}

package com.hyf.spring.ioc.xml.ioc;

public class StaticFactory {

    public static Account getAccount(){
        return new Account();
    }
}

package com.hyf.spring.test.xml.ioc;

public class Account {

    public void init(){
        System.out.println("对象创建");
    }

    public void destroy(){
        System.out.println("对象销毁......");
    }

}
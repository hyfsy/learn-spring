package com.hyf.spring2.mix.lifecycle;

/**
 * @author baB_hyf
 * @date 2020/02/22
 */
public class UserLifeCycle {

    public UserLifeCycle(){
        System.out.println("constructor method call...");
    }

    public void init(){
        System.out.println("init method call...");
    }

    public void destroy(){
        System.out.println("destroy method call...");
    }
}

package com.hyf.spring2.mix.lifecycle;

import java.io.Closeable;

/**
 * @author baB_hyf
 * @date 2020/02/22
 */
public class DefaultLifeCycle {

    public void close(){
        System.out.println("close method call");
    }

    public void shutdown(){
        System.out.println("shutdown method call");
    }
}

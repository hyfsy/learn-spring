package com.hyf.spring3.aop.service;

import com.hyf.spring3.aop.annotation.PCDA;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
public interface WorldService {

    void say();

    void world(String msg, HelloService helloService);

    void sayAnn(PCDA pcda);

    void sayAnn2(PCDA pcda, PCDA pcda2);
}

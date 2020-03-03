package com.hyf.spring3.aop.service.impl;

import com.hyf.spring3.aop.annotation.PCDA;
import com.hyf.spring3.aop.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Service("helloService")
@PCDA
public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl(){
        System.out.println("init");
    }

    @Override
    public void say() {
        System.out.println("my hello");
    }
}

package com.hyf.spring3.aop.service.impl;

import com.hyf.spring3.aop.annotation.PCDA;
import com.hyf.spring3.aop.service.HelloService;
import com.hyf.spring3.aop.service.WorldService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Service("worldService")
public class WorldServiceImpl implements WorldService {

    @Override
    public void say() {
        System.out.println("my world");
    }

    @Override
    public void world(String msg, HelloService helloService) {
        System.out.println("world -> " + msg);
        System.out.println("service -> " + helloService);
    }

    @Override
    public void sayAnn(PCDA pcda) {
        System.out.println("args one -> " + pcda);
    }

    @Override
    @PCDA
    public void sayAnn2(PCDA pcda, PCDA pcda2) {
        System.out.println("args two1 -> " + pcda);
        System.out.println("args two2 -> " + pcda2);
    }
}

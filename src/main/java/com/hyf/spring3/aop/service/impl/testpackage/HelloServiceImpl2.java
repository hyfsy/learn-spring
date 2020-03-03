package com.hyf.spring3.aop.service.impl.testpackage;

import com.hyf.spring3.aop.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Service("helloService2")
public class HelloServiceImpl2 implements HelloService {
    @Override
    public void say() {
        System.out.println("i'm two hello..");
    }
}

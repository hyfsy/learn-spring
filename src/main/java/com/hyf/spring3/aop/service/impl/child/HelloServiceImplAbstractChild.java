package com.hyf.spring3.aop.service.impl.child;

import com.hyf.spring3.aop.service.impl.HelloServiceImplAbstract;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Component("helloServiceChild")
public class HelloServiceImplAbstractChild extends HelloServiceImplAbstract {

    public void noOverride(){
        System.out.println("child no override");
    }

    @Override
    public void overrideMethod() {
        System.out.println("override method doing....");
    }

}

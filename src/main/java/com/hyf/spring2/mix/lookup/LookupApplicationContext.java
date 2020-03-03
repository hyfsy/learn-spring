package com.hyf.spring2.mix.lookup;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author baB_hyf
 * @date 2020/02/22
 */
public class LookupApplicationContext implements ApplicationContextAware {


    private ApplicationContext context;

    public void doSomething(){
        Pojo pojo = getPojo();
        pojo.printMyself();
    }

    /**
     * 同样达到返回依赖为多例对象的情况
     */
    public Pojo getPojo(){
        return (Pojo)context.getBean("pojo");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


}

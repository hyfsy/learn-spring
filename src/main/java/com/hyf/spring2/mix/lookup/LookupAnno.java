package com.hyf.spring2.mix.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



/**
 * @author baB_hyf
 * @date 2020/02/22
 */
@Component
public abstract class LookupAnno {

    public void lookupPojo() {
        Pojo2 pojo = createPojo();
        pojo.printMyself();
    }

    /**
     * <public|protected> [abstract] <return-type> theMethodName(no-arguments);
     * 注解也可以指定一个对应id的bean
     * 或者通过方法的返回类型去寻找
     */
    @Lookup
    protected abstract Pojo2 createPojo();

    /**
     * 有点问题，这
     * 好像在lookup注释的方法内声明不太好
     */
    @Bean
    @Scope("prototype")
    public Pojo2 getPojo2(){
        return new Pojo2();
    }

}


class Pojo2 {

    public void printMyself() {
        System.out.println(this);
    }
}
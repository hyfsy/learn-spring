package com.hyf.spring2.mix.bean;

import com.hyf.spring2.pojo.Clazz;
import com.hyf.spring2.pojo.Teacher;
import com.hyf.spring2.pojo.User;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2020/02/23
 */
@Component
public class BeanConfig {

    @Bean
    @Lazy
    public User user(){
        return new User();
    }

//    @Bean
//    public Clazz clazz(InjectionPoint injectionPoint){
//        System.out.println(injectionPoint.getMember());
//        System.out.println(injectionPoint);
//        return new Clazz();
//    }

//    @Bean
//    @Scope("prototype")
//    public Teacher teacher(DependencyDescriptor injectionPoint){
//        System.out.println(injectionPoint.getMember());
//        System.out.println(injectionPoint);
//        return new Teacher();
//    }

//    @Bean
//    public InjectionPoint injectionPoint(){
//        return new DependencyDescriptor();
//    }

}

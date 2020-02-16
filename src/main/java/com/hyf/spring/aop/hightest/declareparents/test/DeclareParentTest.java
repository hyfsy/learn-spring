package com.hyf.spring.aop.hightest.declareparents.test;

import com.hyf.spring.aop.hightest.declareparents.service.AnimalService;
import com.hyf.spring.aop.hightest.declareparents.service.PersonService;
import com.hyf.spring.aop.hightest.declareparents.util.DeclareParentAspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/16
 */
public class DeclareParentTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DeclareParentAspect.class);
        PersonService personService = ioc.getBean("personService", PersonService.class);
        personService.eatWildlife();

        // 此处能够强转
        AnimalService animalService = (AnimalService)personService;
        animalService.killPerson();

        // 此处不能转换
//        AnimalService animalService = ioc.getBean("animalService", AnimalService.class);
//        animalService.killPerson();
//        System.out.println(animalService);
//
//        // 此处强转会报错
//        PersonService personService2 = (PersonService)animalService;
//
//        personService2.eatWildlife();
    }
}

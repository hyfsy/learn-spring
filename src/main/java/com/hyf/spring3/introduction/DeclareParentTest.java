package com.hyf.spring3.introduction;

import com.hyf.spring3.introduction.service.AnimalService;
import com.hyf.spring3.introduction.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/16
 */
public class DeclareParentTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring3/aop.xml");
        PersonService personService = context.getBean("personService", PersonService.class);
        personService.eatWildlife();

        // 转换为第二个实现接口
        AnimalService animalService = (AnimalService)personService;
        animalService.killPerson();

    }
}

package com.hyf.spring5.test;

import com.hyf.spring5.pojo.Constant;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author baB_hyf
 * @date 2020/03/06
 */
public class ConstantUtilTest {

    @Test
    public void testConstant() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring5/util.xml");

        Constant constant = context.getBean("con1", Constant.class);
        System.out.println(constant);

        Constant constant2 = context.getBean("con2", Constant.class);
        System.out.println(constant2);
    }

    @Test
    public void testPropertyPath() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring5/util.xml");

        Constant constant3 = context.getBean("con3", Constant.class);
        System.out.println(constant3);

        Integer i1 = context.getBean("con3.isolation", Integer.class);
        System.out.println(i1);

        Integer i2 = context.getBean("con3Isolation", Integer.class);
        System.out.println(i2);

        Integer i3 = context.getBean("myIsolation", Integer.class);
        System.out.println(i3);

        Constant constant4 = context.getBean("con4", Constant.class);
        System.out.println(constant4);

    }

    @Test
    public void testProperties() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring5/util.xml");

        Properties prop1 = context.getBean("jdbc1", Properties.class);
        System.out.println(prop1);

        Properties prop2 = context.getBean("jdbc2", Properties.class);
        System.out.println(prop2);
    }

    @Test
    public void testCollection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring5/util.xml");

        List list1 = context.getBean("list1", List.class);
        System.out.println(list1);

        Set set1 = context.getBean("set1", Set.class);
        System.out.println(set1);

        Map map1 = context.getBean("map1", Map.class);
        System.out.println(map1);

    }
}

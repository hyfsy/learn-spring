package com.hyf.spring.ioc.generic;

import com.hyf.spring.ioc.generic.service.BookService;
import com.hyf.spring.ioc.generic.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 原理：通过 getClass().getGenericSuperclass() 获取泛型
 */
public class GenericTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("generic.xml");

    @Test
    public void testGenericType() {
        BookService bookService = ioc.getBean(BookService.class);
        UserService userService = ioc.getBean(UserService.class);
        bookService.save();
        userService.save();
    }
}

package com.hyf.spring.web;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方法一：获取Spring容器
        ApplicationContext ioc = (ApplicationContext)this.getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        // 方法二：获取Spring容器
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        // 方法三：获取Spring容器
        WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();


        User user = ioc.getBean("user", User.class);
        User user1 = webApplicationContext.getBean("user", User.class);
        User user2 = currentWebApplicationContext.getBean("user", User.class);
        System.out.println(user == user1);
        System.out.println(user1 == user2);
    }

}

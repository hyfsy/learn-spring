package com.hyf.spring2.test;

import com.hyf.spring2.mix.abstracttemplate.Child;
import com.hyf.spring2.mix.abstracttemplate.Parent;
import com.hyf.spring2.mix.bean.BeanConfig;
import com.hyf.spring2.mix.bean.ComponentBean;
import com.hyf.spring2.mix.beanpostprocessor.HandBeanPostProcessor;
import com.hyf.spring2.mix.beanpostprocessor.OrderedBeanPostProcessor;
import com.hyf.spring2.mix.lifecycle.DefaultLifeCycle;
import com.hyf.spring2.mix.lifecycle.UserLifeCycle;
import com.hyf.spring2.mix.lookup.LookupAnno;
import com.hyf.spring2.mix.lookup.LookupClass;
import com.hyf.spring2.mix.replace.RealMethod;
import com.hyf.spring2.pojo.Clazz;
import com.hyf.spring2.pojo.Teacher;
import com.hyf.spring2.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author baB_hyf
 * @date 2020/02/21
 */
public class Test1 {


    /**
     * 测试导入外部xml
     */
    @Test
    public void testImportEnertnalXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2/test1/importInternal.xml");

        Clazz clazz = context.getBean("clazz", Clazz.class);
        System.out.println(clazz);
    }

    /**
     * 测试bean的别名
     */
    @Test
    public void testAlias() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2/test1/alias.xml");
        User user = context.getBean("user5", User.class);
        System.out.println(user);
        User user7 = context.getBean("user7", User.class);
        System.out.println(user7);
    }

    /**
     * 测试xml依赖查找
     */
    @Test
    public void testLookup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2/test1/lookup.xml");

        LookupClass lookupClass = context.getBean("lookupClass", LookupClass.class);

        // 每次获取不同的对象
        lookupClass.lookupPojo();
        lookupClass.lookupPojo();
    }

    /**
     * 测试注解依赖查找
     */
    @Test
    public void testLookup2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LookupAnno.class);

        LookupAnno lookupAnno = context.getBean("lookupAnno", LookupAnno.class);

        // 每次获取不同的对象
        lookupAnno.lookupPojo();
        lookupAnno.lookupPojo();
    }

    /**
     * 测试任意方法替换
     */
    @Test
    public void testMethodReplace() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2/test1/replacemethod.xml");

        RealMethod realMethod = context.getBean("realMethod", RealMethod.class);
        realMethod.printMethod(1, 2, 3);

    }

    /**
     * 测试原型bean的生命周期回调方法的执行
     */
    @Test
    public void testPrototypeLifeCycle() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring2/test1/prototypelifecycle.xml");

        UserLifeCycle userLifeCycle = context.getBean("userLifeCycle", UserLifeCycle.class);
        System.out.println(userLifeCycle);

        System.out.println("======");

        DefaultLifeCycle defaultLifeCycle = context.getBean("defaultLifeCycle", DefaultLifeCycle.class);
        System.out.println(defaultLifeCycle);

        context.close();

    }

    /**
     * 测试父bean定义模板是否会生成bean实例
     * 结论：只要指定属性为abstract=true就不会创建该bean
     */
    @Test
    public void testAbstractTemplate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring2/test1/abstract.xml");


        Child child = context.getBean("child", Child.class);
        System.out.println(child);

        Parent parent = context.getBean("parent", Parent.class);
        System.out.println(parent);

    }

    /**
     * 测试手动设置的后置处理器的执行顺序
     * 结论：手动的永远先执行，并在初始化时会执行六次，待探索
     * 手动的后置处理器不会被放入到单例池中
     */
    @Test
    public void testHandlerBeanPostProcessorOrdered() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 手动添加后置处理器
        context.getBeanFactory().addBeanPostProcessor(new HandBeanPostProcessor());

        // 自动扫描注册
        context.register(OrderedBeanPostProcessor.class);
        context.refresh();

        HandBeanPostProcessor bean = context.getBean(HandBeanPostProcessor.class);
        System.out.println(bean);

    }

    /**
     * 测试InjectionPoint
     * 失败
     */
    @Test
    public void testInjectionPoint() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user);
//        Clazz clazz = context.getBean(Clazz.class);
//        Teacher teacher = context.getBean(Teacher.class);
//        Teacher teacher2 = context.getBean(Teacher.class);
//
//        System.out.println(clazz);
//        System.out.println(teacher);
//        System.out.println(teacher2);
    }

    /**
     * 测试@Component注解中定义@Bean之间依赖
     * 结论：Component注解中定义的会返回两个bean
     */
    @Test
    public void testComponentBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentBean.class);
        User user = context.getBean(User.class);
        System.out.println(user);
        Clazz clazz = context.getBean(Clazz.class);
        System.out.println(clazz);
    }

    /**
     * 测试不同应用程序上下文创建出来的Resource
     */
    @Test
    public void testCreateApplicationContext() {
        String common = "asdf";
        String classPath = "classpath:alias.xml";
        String file = "file:///E:\\study\\idea2\\learn-spring\\src\\main\\resources\\spring2\\test1\\child.xml";
        String url = "http://www.baidu.com";

        ClassPathXmlApplicationContext classPathXml = new ClassPathXmlApplicationContext();
        ApplicationContext fileSystem = new FileSystemXmlApplicationContext();
        System.out.println("classPath:");
        System.out.println(classPathXml.getResource(common).getClass());
        System.out.println(classPathXml.getResource(classPath).getClass());
        System.out.println(classPathXml.getResource(file).getClass());
        System.out.println(classPathXml.getResource(url).getClass());
        System.out.println("fileSystem:");
        System.out.println(fileSystem.getResource(common).getClass());
        System.out.println(fileSystem.getResource(classPath).getClass());
        System.out.println(fileSystem.getResource(file).getClass());
        System.out.println(fileSystem.getResource(url).getClass());
    }

}

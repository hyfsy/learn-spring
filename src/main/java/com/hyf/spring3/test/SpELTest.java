package com.hyf.spring3.test;

import com.hyf.spring3.pojo.Person;
import com.hyf.spring3.spel.StringUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2020/02/29
 */
public class SpELTest {

    @Test
    public void test1() throws Exception {

        // 主要解析表达式的对象：ExpressionParser
        // 可以传入 SpelParserConfiguration 指定使用解析集合的特殊方式或编译方式
        ExpressionParser parser = new SpelExpressionParser();

        // 解析完毕封装为一个Expression对象
        // 可以传入 ParserContext 指定使用定界符，比如 #{}，或自定义
        Expression expression = parser.parseExpression("1+5");

        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        // 获取结果
        // 可以传入 EvaluationContext 对象，如SimpleEvaluationContext，指定解析的访问权限
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);



        // 解析map
        Map mapValue = parser.parseExpression("{'key':'value'}").getValue(Map.class);
        System.out.println(mapValue);



        // 解析方法
        Object value1 = parser.parseExpression("expressionInvoke('张三')").getValue(this);
        System.out.println(value1);



        // #this & #root
        Person person = new Person(1,"张三", 18);
        context.setVariable("newName", "李四");
        Object variables = parser.parseExpression("#newName + ' ' + #this + '\n' + #root").getValue(context, person);
        System.out.println(variables);



        // 设置自定义方法
        context.setVariable("reverseString", StringUtils.class.getDeclaredMethod("reverseString", String.class));
        String value2 = parser.parseExpression("#reverseString('张三')").getValue(context, String.class);
        System.out.println(value2);
        // or up my only
        // ??? class.getName()
        String value3 = parser.parseExpression("getName()").getValue(Person.class, String.class);
        System.out.println(value3);



        // 默认的只能在前面
        Boolean value4 = parser.parseExpression("true?:false").getValue(Boolean.class);
        System.out.println(value4);



        // 容器中获取bean引用
        ApplicationContext app = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) app).refresh();
        standardEvaluationContext.setBeanResolver(new BeanFactoryResolver(app));
//        Object value5 = parser.parseExpression("@test").getValue(standardEvaluationContext);
//        System.out.println(value5);



        Map<String, Integer> testMap = new HashMap<>(3);
        testMap.put("1", 1);
        testMap.put("2", 8);
        testMap.put("3", 18);
        context.setVariable("testMap", testMap);



        Object value5 = parser.parseExpression("#testMap.?[key>'1']").getValue(context);
        System.out.println(value5);



    }

    /**
     * 自定义方法调用
     */
    public String expressionInvoke(String name){
        System.out.println(name);
        return name;
    }

}

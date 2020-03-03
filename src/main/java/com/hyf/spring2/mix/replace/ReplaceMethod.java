package com.hyf.spring2.mix.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 替换的方法
 *
 * @author baB_hyf
 * @date 2020/02/22
 */
public class ReplaceMethod implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

        System.out.println(obj);
        System.out.println(method);
        System.out.println(Arrays.asList(args));

        return "replace success";
    }

}

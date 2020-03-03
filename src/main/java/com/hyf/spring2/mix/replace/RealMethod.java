package com.hyf.spring2.mix.replace;

/**
 * @author baB_hyf
 * @date 2020/02/22
 */
public class RealMethod {

    /**
     * 被替换的方法
     */
    public void printMethod(Integer testArg, Integer testArg2, Integer testArg3) {
        System.out.println("real method will not be call");
    }
}

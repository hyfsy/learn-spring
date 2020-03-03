package com.hyf.spring3.aop.service;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
public interface JpService {

    String getString();

    void throwException() throws IllegalArgumentException;
}

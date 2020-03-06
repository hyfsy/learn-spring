package com.hyf.spring4.service.impl;

import com.hyf.spring4.service.AnotherService;

/**
 * @author baB_hyf
 * @date 2020/03/03
 */
public class AnotherServiceImpl implements AnotherService {
    @Override
    public void anotherSay() {
        System.out.println("another also want to say");
    }
}

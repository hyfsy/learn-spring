package com.hyf.spring4.service.impl;

import com.hyf.spring4.service.ProxyUseService;

/**
 * @author baB_hyf
 * @date 2020/03/03
 */
public class ProxyUseServiceImpl implements ProxyUseService {
    @Override
    public void speak() {
        System.out.println("i have a lot to say...");
    }
}

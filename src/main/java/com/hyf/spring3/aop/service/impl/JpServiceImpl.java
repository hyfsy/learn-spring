package com.hyf.spring3.aop.service.impl;

import com.hyf.spring3.aop.service.JpService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Service("jpService")
public class JpServiceImpl implements JpService {

    @Override
    public String getString() {
        System.out.println("getString did ...");
        return "getString did ...";
    }

    @Override
    public void throwException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
}

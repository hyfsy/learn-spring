package com.hyf.spring3.aop.service.impl;

import com.hyf.spring3.aop.service.Sample;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
@Service("sample")
public class SampleImpl implements Sample<String> {
    @Override
    public void sampleGenericMethod(String param) {
        System.out.println("method invoke: "+param);
    }

    @Override
    public void sampleGenericCollectionMethod(Collection<String> param) {
        System.out.println("collection param -> " + param);
    }
}

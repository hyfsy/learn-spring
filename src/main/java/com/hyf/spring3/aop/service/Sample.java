package com.hyf.spring3.aop.service;

import java.util.Collection;

/**
 * @author baB_hyf
 * @date 2020/03/01
 */
public interface Sample<T> {
    void sampleGenericMethod(T param);
    void sampleGenericCollectionMethod(Collection<T> param);
}
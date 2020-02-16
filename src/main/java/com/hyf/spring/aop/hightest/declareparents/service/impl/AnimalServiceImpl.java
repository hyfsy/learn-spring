package com.hyf.spring.aop.hightest.declareparents.service.impl;

import com.hyf.spring.aop.hightest.declareparents.service.AnimalService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/02/16
 */
@Service("animalService")
public class AnimalServiceImpl implements AnimalService {
    @Override
    public void killPerson() {
        System.out.println("i am blank man, xxx aaa...");
    }
}

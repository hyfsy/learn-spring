package com.hyf.spring3.introduction.service.impl;

import com.hyf.spring3.introduction.service.AnimalService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

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

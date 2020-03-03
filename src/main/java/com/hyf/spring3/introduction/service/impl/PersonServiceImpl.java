package com.hyf.spring3.introduction.service.impl;

import com.hyf.spring3.introduction.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/02/16
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Override
    public void eatWildlife() {
        System.out.println("开始吃野生动物");
    }
}

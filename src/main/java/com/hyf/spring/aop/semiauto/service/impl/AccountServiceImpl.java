package com.hyf.spring.aop.semiauto.service.impl;

import com.hyf.spring.aop.semiauto.service.IAccountService;
import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void printAccount(Integer money){
        System.out.println("print account: " + money);
    }
}

package com.hyf.spring.test.hello.service.impl;

import com.hyf.spring.test.hello.BeanFactory;
import com.hyf.spring.test.hello.dao.IAccountDao;
import com.hyf.spring.test.hello.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void getAllAccount() {

        // private IAccountDao accountDao = new AccountDaoImpl();

        IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

        accountDao.getAllAccount();
    }

}

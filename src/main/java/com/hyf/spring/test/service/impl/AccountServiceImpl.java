package com.hyf.spring.test.service.impl;

import com.hyf.spring.test.BeanFactory;
import com.hyf.spring.test.dao.IAccountDao;
import com.hyf.spring.test.dao.impl.AccountDaoImpl;
import com.hyf.spring.test.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void getAllAccount() {

        // private IAccountDao accountDao = new AccountDaoImpl();

        IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

        accountDao.getAllAccount();
    }
}

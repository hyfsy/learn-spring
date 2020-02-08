package com.hyf.spring.test.xml.hello.dao.impl;

import com.hyf.spring.test.xml.hello.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {

    @Override
    public void getAllAccount() {
        System.out.println("获取账户信息成功");
    }
}

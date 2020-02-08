package com.hyf.spring.test.annotation.service.impl;

import com.hyf.spring.test.annotation.dao.IAccountDao;
import com.hyf.spring.test.annotation.pojo.Account;
import com.hyf.spring.test.annotation.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> getAllAccount() {
        return accountDao.getAllAccount();
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountDao.getAccountById(id);
    }

    @Override
    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccountById(Integer id) {
        accountDao.deleteAccountById(id);
    }
}

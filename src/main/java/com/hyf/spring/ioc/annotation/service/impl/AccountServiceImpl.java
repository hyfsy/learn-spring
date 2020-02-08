package com.hyf.spring.ioc.annotation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyf.spring.ioc.annotation.dao.IAccountDao;
import com.hyf.spring.ioc.annotation.pojo.Account;
import com.hyf.spring.ioc.annotation.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService
{

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

    /**
     * 已在动态代理中实现对事物的控制
     */
    @Override
    public void transfer(Integer sourceId, Integer targetId, Double money) {

        // 进行转账操作
        Account sourceAccount = accountDao.getAccountById(sourceId);
        Account targetAccount = accountDao.getAccountById(targetId);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.updateAccount(sourceAccount);
        int i = 1 / 0;
        accountDao.updateAccount(targetAccount);
    }
}

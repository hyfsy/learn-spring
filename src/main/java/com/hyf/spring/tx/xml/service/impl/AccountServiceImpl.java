package com.hyf.spring.tx.xml.service.impl;

import java.util.List;

import com.hyf.spring.tx.xml.pojo.Account;
import com.hyf.spring.tx.xml.dao.IAccountDao;
import com.hyf.spring.tx.xml.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
// @EnableTransactionManagement
// @Transactional
public class AccountServiceImpl implements IAccountService
{

    @Autowired
    private IAccountDao accountDao;

    // @Transactional(readOnly = true)
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
     * 测试xml事务控制方法
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

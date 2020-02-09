package com.hyf.spring.tx.xml.service;

import java.util.List;

import com.hyf.spring.tx.xml.pojo.Account;

public interface IAccountService {

    List<Account> getAllAccount();

    Account getAccountById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer id);

    void transfer(Integer sourceId, Integer targetId, Double money);
}

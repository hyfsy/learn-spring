package com.hyf.spring.ioc.annotation.service;

import com.hyf.spring.ioc.annotation.pojo.Account;

import java.util.List;

public interface IAccountService {

    List<Account> getAllAccount();

    Account getAccountById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer id);

    void transfer(Integer sourceId, Integer targetId,  Double money);
}

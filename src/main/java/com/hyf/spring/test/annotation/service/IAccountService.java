package com.hyf.spring.test.annotation.service;

import com.hyf.spring.test.annotation.pojo.Account;

import java.util.List;

public interface IAccountService {

    List<Account> getAllAccount();

    Account getAccountById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer id);
}

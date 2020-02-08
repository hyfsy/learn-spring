package com.hyf.spring.test.annotation.dao;


import com.hyf.spring.test.annotation.pojo.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> getAllAccount();

    Account getAccountById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer id);
}
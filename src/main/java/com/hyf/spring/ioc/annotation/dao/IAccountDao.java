package com.hyf.spring.ioc.annotation.dao;


import com.hyf.spring.ioc.annotation.pojo.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> getAllAccount();

    Account getAccountById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer id);
}

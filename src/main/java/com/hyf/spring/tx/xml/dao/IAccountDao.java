package com.hyf.spring.tx.xml.dao;


import java.util.List;

import com.hyf.spring.tx.xml.pojo.Account;

public interface IAccountDao {

    List<Account> getAllAccount();

    Account getAccountById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer id);
}

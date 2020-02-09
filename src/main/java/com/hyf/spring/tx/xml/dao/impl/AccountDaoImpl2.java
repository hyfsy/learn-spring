package com.hyf.spring.tx.xml.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyf.spring.tx.xml.dao.IAccountDao;
import com.hyf.spring.tx.xml.pojo.Account;

// @Repository("accountDao")
public class AccountDaoImpl2 implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> getAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account getAccountById(Integer id) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            runner.update("insert into account (name, money) values (?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccountById(Integer id) {
        try {
            runner.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

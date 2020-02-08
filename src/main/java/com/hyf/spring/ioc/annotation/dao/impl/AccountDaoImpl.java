package com.hyf.spring.ioc.annotation.dao.impl;

import com.hyf.spring.ioc.annotation.dao.IAccountDao;
import com.hyf.spring.ioc.annotation.pojo.Account;
import com.hyf.spring.ioc.annotation.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtil connectionUtil;

    @Override
    public List<Account> getAllAccount() {
        try {
            return runner.query(connectionUtil.getConnection(), "select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account getAccountById(Integer id) {
        try {
            return runner.query(connectionUtil.getConnection(), "select * from account where id = ?", new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            runner.update(connectionUtil.getConnection(), "insert into account (name, money) values (?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtil.getConnection(), "update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccountById(Integer id) {
        try {
            runner.update(connectionUtil.getConnection(), "delete from account where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

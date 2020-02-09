package com.hyf.spring.tx.xml.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hyf.spring.tx.xml.dao.IAccountDao;
import com.hyf.spring.tx.xml.pojo.Account;

// @Repository("accountDao")
public class AccountDaoImpl3 implements IAccountDao
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> getAllAccount() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account getAccountById(Integer id) {
        return jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id).get(0);
    }

    @Override
    public void insertAccount(Account account) {
        jdbcTemplate.update("insert into account (name, money) values (?, ?)", account.getName(), account.getMoney());
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteAccountById(Integer id) {
        jdbcTemplate.update("delete from account where id = ?", id);
    }
}

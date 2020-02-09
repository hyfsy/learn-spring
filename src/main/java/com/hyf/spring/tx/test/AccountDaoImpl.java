package com.hyf.spring.tx.test;

import com.hyf.spring.ioc.annotation.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 需要在该Dao实现类的xml文件中配置dataSource属性
 * 在注解中无法使用 JdbcDaoSupport
 */
public class AccountDaoImpl extends JdbcDaoSupport {

    public List<Account> insertAccount(){
        return getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<>(Account.class));
    }
}

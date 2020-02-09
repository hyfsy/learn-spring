package com.hyf.spring.tx.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hyf.spring.tx.xml.pojo.Account;

public class JdbcTemplateTest {

    @Test
    public void testSelect() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);

        // 测试删除
        jdbcTemplate.execute("delete from account where id = 1");

        // 测试增加方法
        jdbcTemplate.update("insert into account (name, money) values (?, ?)", "测试jdbcTemplate增加", 1000);

        // 查询一行一列信息
        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Long.class, 10);
        System.out.println(count);

        // 测试查询方法
        // 需要一个RowMapper对象映射结果集到实体(集合)的封装
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ?", new AccountRowMapper(), 4);

        // spring提供的自动封装结果集的RowMapper实现
        List<Account> accountList2 = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 4);

        System.out.println(accountList);
        System.out.println(accountList2);
    }
}

/**
 * 设置结果集与实体的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getDouble("money"));
        return account;
    }
}
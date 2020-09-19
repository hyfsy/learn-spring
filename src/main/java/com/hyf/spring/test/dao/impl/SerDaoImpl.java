package com.hyf.spring.test.dao.impl;

import com.hyf.spring.test.dao.ISerDao;
import com.hyf.spring.test.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author baB_hyf
 * @date 2020/05/13
 */
@Service("serDao")
public class SerDaoImpl implements ISerDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public void add(Account account) {
        try {
            runner.update("insert into account (name, money) values (?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

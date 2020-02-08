package com.hyf.spring.ioc.annotation.util;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 事务管理器
 */
@Component
public class TransactionManager {

    @Autowired
    ConnectionUtil connectionUtil;

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtil.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtil.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭事务
     */
    public void close(){
        try {
            // 关闭连接
            connectionUtil.getConnection().close();
            // 解除与线程的绑定
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

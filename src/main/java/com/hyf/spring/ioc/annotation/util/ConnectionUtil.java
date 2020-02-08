package com.hyf.spring.ioc.annotation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    /**
     * 获取连接，并与当前线程绑定
     */
    public Connection getConnection(){
        try {
            Connection conn = tl.get();
            if(conn == null) {
                conn = dataSource.getConnection();
                // 将连接与当前线程绑定
                tl.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将当前线程与连接解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}

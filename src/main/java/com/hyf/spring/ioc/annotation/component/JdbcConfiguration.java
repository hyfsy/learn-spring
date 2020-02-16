package com.hyf.spring.ioc.annotation.component;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 指定扫描的文件
 */
@PropertySource("classpath:jdbc.properties")
public class JdbcConfiguration {

    @Value("${jdbc.mysql.driver}")
    private String driver;

    @Value("${jdbc.mysql.url}")
    private String url;

    @Value("${jdbc.mysql.username}")
    private String userName;

    @Value("${jdbc.mysql.password}")
    private String password;

    /**
     * 创建dbutils的操作数据库对象，指定为多例类型
     * 带事务操作
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner getQueryRunner(){
        return new QueryRunner();
    }

//    @Bean(name = "runner")
//    @Scope("prototype")
//    public QueryRunner getQueryRunner(@Qualifier("dataSource") DataSource dataSource){
//        return new QueryRunner(dataSource);
//    }



    /**
     * 创建数据库连接池
     */
    @Bean(name = "dataSource")
    @Profile("dev")
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        System.out.println("创建开发环境的数据源");
        return dataSource;
    }

    @Bean
    @Profile("test")
    public DataSource getTestDataSource(){
        System.out.println("创建测试环境的数据源");
        return new DriverManagerDataSource();
    }

    @Bean
    @Profile("pro")
    public DataSource getProDataSource(){
        System.out.println("创建生产环境的数据源");
        return new SingleConnectionDataSource();
    }

    @Bean("connection")
    public Connection getConnection(DataSource dataSource){
        // 初始化事务同步器
        TransactionSynchronizationManager.initSynchronization();
        // 使用spring的数据源工具类获取当前线程的连接
        return DataSourceUtils.getConnection(dataSource);
    }
}

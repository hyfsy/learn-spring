package com.hyf.spring.test.annotation.component;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

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
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner getQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据库连接池
     */
    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
}

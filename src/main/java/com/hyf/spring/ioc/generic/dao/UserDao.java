package com.hyf.spring.ioc.generic.dao;

import com.hyf.spring.ioc.generic.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("userDao保存了");
    }
}

package com.hyf.spring.ioc.generic.service;

import com.hyf.spring.ioc.generic.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注意此处service类上的泛型
 * @param <T>
 */
public class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void save(){
        System.out.println("保存了：" + baseDao);
        baseDao.save();
    }
}

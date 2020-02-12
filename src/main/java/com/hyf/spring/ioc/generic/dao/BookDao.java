package com.hyf.spring.ioc.generic.dao;

import com.hyf.spring.ioc.generic.pojo.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void save() {
        System.out.println("bookDao保存了");
    }
}

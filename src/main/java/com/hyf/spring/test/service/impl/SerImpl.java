package com.hyf.spring.test.service.impl;

import com.hyf.spring.test.dao.ISerDao;
import com.hyf.spring.test.pojo.Account;
import com.hyf.spring.test.service.ISer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baB_hyf
 * @date 2020/05/13
 */
@Service("ser")
public class SerImpl implements ISer {

    @Autowired
    private ISerDao serDao;

    @Transactional
    @Override
    public void add(Account account) {
        serDao.add(account);
        int i = 1/0;
        serDao.add(account);
    }
}

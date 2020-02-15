package com.hyf.spring.ioc.hightest.highimport.selector.service.impl;

import com.hyf.spring.ioc.hightest.highimport.selector.service.ImportService;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
public class ImportServiceImpl implements ImportService {
    @Override
    public void printImport() {
        System.out.println(this);
    }
}

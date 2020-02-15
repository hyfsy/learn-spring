package com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.service.impl;

import com.hyf.spring.ioc.hightest.highimport.beandefinitionregistrar.service.ImportService;

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

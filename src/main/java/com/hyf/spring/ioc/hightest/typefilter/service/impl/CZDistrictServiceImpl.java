package com.hyf.spring.ioc.hightest.typefilter.service.impl;

import com.hyf.spring.ioc.hightest.typefilter.anno.District;
import com.hyf.spring.ioc.hightest.typefilter.service.DistrictService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
@District("cz")
@Service("districtService")
public class CZDistrictServiceImpl implements DistrictService {
    @Override
    public void printDistrict() {
        System.out.println("常州服务启动...");
    }
}

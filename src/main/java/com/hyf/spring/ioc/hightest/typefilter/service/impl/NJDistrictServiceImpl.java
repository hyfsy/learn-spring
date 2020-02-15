package com.hyf.spring.ioc.hightest.typefilter.service.impl;

import com.hyf.spring.ioc.hightest.typefilter.anno.District;
import com.hyf.spring.ioc.hightest.typefilter.service.DistrictService;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/02/15
 */
@District("nj")
@Service("districtService")
public class NJDistrictServiceImpl implements DistrictService {
    @Override
    public void printDistrict() {
        System.out.println("南京服务启动...");
    }
}

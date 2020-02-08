package com.hyf.spring.test.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("other")
@Scope("prototype")
public class TestOther {

    @Autowired
    private TestController testController;

    @Autowired
    @Qualifier("testService")
    private TestService testService;

    @Resource(name = "testDao")
    private TestDao testDao;

    @Value("1")
    private Integer id;
}

@Controller
class TestController {

    @PostConstruct
    public void init(){
        System.out.println("对象创建");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("对象销毁......");
    }
}

@Service
interface TestService {
}

@Repository
interface TestDao {
}



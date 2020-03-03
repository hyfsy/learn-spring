package com.hyf.spring2.mix.bean;

import com.hyf.spring2.pojo.Clazz;
import com.hyf.spring2.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2020/02/23
 */
//@Configuration
@Component
public class ComponentBean {

    @Bean
    public Clazz clazz(User user) {
        return new Clazz(user());
    }

    @Bean
    public User user() {
        return new User();
    }
}

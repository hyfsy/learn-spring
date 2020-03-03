package com.hyf.spring2.mix.event;

import org.springframework.context.ApplicationListener;

/**
 * 自定义事件的处理监听者
 *
 * @author baB_hyf
 * @date 2020/02/24
 */
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("accept my event: " + event);
    }

}

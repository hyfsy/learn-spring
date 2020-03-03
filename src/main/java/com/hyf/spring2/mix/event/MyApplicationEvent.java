package com.hyf.spring2.mix.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * 要手动通过应用程序事件发布者注册
 *
 * @author baB_hyf
 * @date 2020/02/24
 */
public class MyApplicationEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}

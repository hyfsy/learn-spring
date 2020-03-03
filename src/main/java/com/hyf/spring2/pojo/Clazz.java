package com.hyf.spring2.pojo;

import java.beans.ConstructorProperties;

/**
 * @author baB_hyf
 * @date 2020/02/21
 */
public class Clazz {

    private User user;

    public Clazz() {
    }

    public Clazz(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "user=" + user +
                '}';
    }
}

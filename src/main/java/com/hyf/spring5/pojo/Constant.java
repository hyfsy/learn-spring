package com.hyf.spring5.pojo;

/**
 * @author baB_hyf
 * @date 2020/03/06
 */
public class Constant {
    private Integer isolation;

    public Integer getIsolation() {
        return isolation;
    }

    public void setIsolation(Integer isolation) {
        this.isolation = isolation;
    }

    @Override
    public String toString() {
        return "Constant{" +
                "isolation=" + isolation +
                '}';
    }
}

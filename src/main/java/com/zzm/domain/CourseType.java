package com.zzm.domain;


import java.io.Serializable;
public class CourseType implements Serializable {
    private Integer c_t_id;
    private String c_t_name;

    public Integer getC_t_id() {
        return c_t_id;
    }

    public void setC_t_id(Integer c_t_id) {
        this.c_t_id = c_t_id;
    }

    public String getC_t_name() {
        return c_t_name;
    }

    public void setC_t_name(String c_t_name) {
        this.c_t_name = c_t_name;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "c_t_id=" + c_t_id +
                ", c_t_name='" + c_t_name + '\'' +
                '}';
    }
}

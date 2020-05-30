package com.zzm.domain;


import java.io.Serializable;
public class CourseSection implements Serializable {
    private Integer c_s_id;
    private Integer c_id;
    private Integer c_s_sequence;
    private String c_s_name;
    private String url;

    public Integer getC_s_id() {
        return c_s_id;
    }

    public void setC_s_id(Integer c_s_id) {
        this.c_s_id = c_s_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_s_sequence() {
        return c_s_sequence;
    }

    public void setC_s_sequence(Integer c_s_sequence) {
        this.c_s_sequence = c_s_sequence;
    }

    public String getC_s_name() {
        return c_s_name;
    }

    public void setC_s_name(String c_s_name) {
        this.c_s_name = c_s_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CourseSection{" +
                "c_s_id=" + c_s_id +
                ", c_id=" + c_id +
                ", c_s_sequence=" + c_s_sequence +
                ", c_s_name='" + c_s_name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

package com.zzm.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Course implements Serializable {
    private Integer c_id;
    private String c_name;
    private String c_abstract;
    private Integer c_t_id;
    private Integer upid;
    private Date c_date;

    //一对一关系映射
    private User user;
    //一对多关系映射
    private List<CourseSection> courseSections;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_abstract() {
        return c_abstract;
    }

    public void setC_abstract(String c_abstract) {
        this.c_abstract = c_abstract;
    }

    public Integer getC_t_id() {
        return c_t_id;
    }

    public void setC_t_id(Integer c_t_id) {
        this.c_t_id = c_t_id;
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CourseSection> getCourseSections() {
        return courseSections;
    }

    public void setCourseSections(List<CourseSection> courseSections) {
        this.courseSections = courseSections;
    }

    @Override
    public String toString() {
        return "Course{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_abstract='" + c_abstract + '\'' +
                ", c_t_id=" + c_t_id +
                ", upid=" + upid +
                ", c_date=" + c_date +
                ", user=" + user +
                ", courseSections=" + courseSections +
                '}';
    }
}

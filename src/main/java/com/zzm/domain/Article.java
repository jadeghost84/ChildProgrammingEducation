package com.zzm.domain;




import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer a_id;
    private Integer upid;
    private String a_name;
    private String a_content;
    private Date a_date;
    private Integer a_like;

    private User user;

    public Integer getA_like() {
        return a_like;
    }

    public void setA_like(Integer a_like) {
        this.a_like = a_like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "a_id=" + a_id +
                ", upid=" + upid +
                ", a_name='" + a_name + '\'' +
                ", a_content='" + a_content + '\'' +
                ", a_date=" + a_date +
                ", a_like=" + a_like +
                ", user=" + user +
                '}';
    }
}

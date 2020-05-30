package com.zzm.domain;

import java.io.Serializable;

public class AdminRole implements Serializable {
    private Integer r_id;
    private String r_name;
    private String r_remark;

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_remark() {
        return r_remark;
    }

    public void setR_remark(String r_remark) {
        this.r_remark = r_remark;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_remark='" + r_remark + '\'' +
                '}';
    }
}

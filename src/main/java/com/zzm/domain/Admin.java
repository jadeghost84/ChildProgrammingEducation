package com.zzm.domain;

import java.io.Serializable;

public class Admin implements Serializable {

    private Integer m_id;
    private String m_name;
    private String m_password;
    private Integer m_role;

    private AdminRole adminRole;

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public Integer getM_role() {
        return m_role;
    }

    public void setM_role(Integer m_role) {
        this.m_role = m_role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_password='" + m_password + '\'' +
                ", m_role=" + m_role +
                ", adminRole=" + adminRole +
                '}';
    }
}

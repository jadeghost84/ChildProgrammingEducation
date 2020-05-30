package com.zzm.service;

import com.zzm.domain.Admin;
import com.zzm.domain.AdminAuthority;
import com.zzm.domain.AdminMenu;
import com.zzm.domain.AdminRole;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();
    public Admin findByUsername(String m_name);
    public AdminRole findRoleByRoleId(Integer r_id);
    public List<AdminAuthority> findAuthorityListByRoleId(Integer r_id);
    public List<AdminMenu> findMenuListByIds(String menuIds);
    public void updateAdmin(Admin admin);
}

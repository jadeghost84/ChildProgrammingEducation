package com.zzm.service.impl;

import com.zzm.dao.AdminDao;
import com.zzm.dao.ArticleDao;
import com.zzm.domain.*;
import com.zzm.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Admin> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        return adminDao.findAll();
    }

    @Override
    public Admin findByUsername(String m_name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        return adminDao.findByUsername(m_name);
    }

    @Override
    public AdminRole findRoleByRoleId(Integer r_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        return adminDao.findRoleByRoleId(r_id);
    }

    @Override
    public List<AdminAuthority> findAuthorityListByRoleId(Integer r_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        return adminDao.findAuthorityListByRoleId(r_id);
    }

    @Override
    public List<AdminMenu> findMenuListByIds(String menuIds) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        List<AdminMenu> adminMenus = new ArrayList<>();
        String[] ids = menuIds.split(",");
        for(int i=0;i<ids.length;i++){
            adminMenus.add(adminDao.findMenuListById(Integer.parseInt(ids[i])));
        }
        return adminMenus;
    }

    @Override
    public void updateAdmin(Admin admin) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        adminDao.updateAdmin(admin);
    }
}

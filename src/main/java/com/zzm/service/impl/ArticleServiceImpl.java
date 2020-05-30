package com.zzm.service.impl;

import com.zzm.dao.ArticleDao;
import com.zzm.dao.CourseDao;
import com.zzm.domain.Article;
import com.zzm.service.ArticleService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public List<Article> findArticleByTopic(String key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
        return articleDao.findArticleByTopic(key);
    }

    @Override
    public List<Article> findArticleByAttention() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
        return articleDao.findArticleByAttention();
    }

    @Override
    public List<Article> findArticleBySpecial() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
        return articleDao.findArticleBySpecial();
    }

    @Override
    public List<Article> findArticleByWeekHot() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
        return articleDao.findArticleByWeekHot();
    }

    @Override
    public List<Article> findArticleByNew() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
        return articleDao.findArticleByNew();
    }
}

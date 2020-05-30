package com.zzm.service;

import com.zzm.domain.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> findArticleByTopic(String key);
    public List<Article> findArticleByAttention();
    public List<Article> findArticleBySpecial();
    public List<Article> findArticleByWeekHot();
    public List<Article> findArticleByNew();
}

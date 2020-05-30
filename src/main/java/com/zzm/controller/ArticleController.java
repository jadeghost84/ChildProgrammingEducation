package com.zzm.controller;

import com.zzm.domain.Article;
import com.zzm.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    @ResponseBody
    public List<Article> getArticles(@RequestParam("type") Integer type,@RequestParam("key") String key){
        //type取值：0为话题，1为关注，2为最新发布，3为专栏，4为周热,只有type0需要key
        List<Article> articles;
        switch (type){
            case 0:
                articles = articleService.findArticleByTopic(key);break;
            case 1:
                articles = articleService.findArticleByAttention();break;
            case 2:
                articles = articleService.findArticleByNew();break;
            case 3:
                articles = articleService.findArticleBySpecial();break;
            case 4:
                articles = articleService.findArticleByWeekHot();break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return articles;
    }
}

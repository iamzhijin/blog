package com.lzhijin.blog.service.bll;

import com.lzhijin.blog.entity.Article;
import com.lzhijin.blog.entity.params.ArticleParams;
import com.lzhijin.blog.service.IArticleService;
import com.lzhijin.blog.util.TokenUtil;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ArticleBLL {

    @Autowired
    IArticleService articleService;
    @Autowired
    TokenUtil tokenUtil;

    /**
     * 新增博客
     *
     * @param params 文章实体
     * @return
     * @author lzhijin
     * @since 2019-09-23
     */
    public Boolean addArticle(ArticleParams params){
        Article article = new Article();
        article.setId(UUIDUtil.getUUID());
        article.setUserId(tokenUtil.getLoginDto().getUserId());
        article.setTitle(params.getTitle());
        article.setContent(params.getContent());
        if(params.getIsPublish()==1){
            article.setIsPublish(1);
            article.setPublishDate(LocalDateTime.now());
        }
        return articleService.save(article);
    }
}

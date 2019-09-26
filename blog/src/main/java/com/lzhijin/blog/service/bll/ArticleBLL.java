package com.lzhijin.blog.service.bll;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzhijin.blog.entity.Article;
import com.lzhijin.blog.entity.dto.ArticleListDTO;
import com.lzhijin.blog.entity.params.ArticleListParams;
import com.lzhijin.blog.entity.params.ArticleParams;
import com.lzhijin.blog.mapper.ArticleMapper;
import com.lzhijin.blog.service.IArticleService;
import com.lzhijin.blog.util.TokenUtil;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleBLL {

    @Autowired
    IArticleService articleService;
    @Resource
    ArticleMapper articleMapper;
    @Autowired
    TokenUtil tokenUtil;

    /**
     * 新增博客
     *
     * @param params 文章实体
     * @return true/false
     * @author lzhijin
     * @since 2019-09-23
     */
    public Boolean addArticle(ArticleParams params){
        Article article = new Article();
        article.setId(UUIDUtil.getUUID());
        article.setUserId(tokenUtil.getLoginDto().getUserId());
        article.setTitle(params.getTitle());
        article.setContent(params.getContent());
        article.setLabelId(params.getLabelId());
        if(params.getIsPublish()==1){
            article.setIsPublish(1);
            article.setPublishDate(LocalDateTime.now());
        }
        return articleService.save(article);
    }

    /**
     * 博客列表查询
     *
     * @param params 标签ID 分页参数
     * @return ArticleListDTO 文章列表实体
     * @author lzhijin
     * @since 2019-09-26
     */
    public Page<ArticleListDTO> getArticleList(ArticleListParams params){
        Page<ArticleListDTO> articlePage = new Page<>(params.getPageNum(), params.getPageSize());
        List<ArticleListDTO> articleList = articleMapper.getArticleList(params.getLabelId(), articlePage);
        return articlePage.setRecords(articleList);
    }
}

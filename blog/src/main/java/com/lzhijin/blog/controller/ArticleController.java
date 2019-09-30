package com.lzhijin.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.dto.ArticleListDTO;
import com.lzhijin.blog.entity.params.ArticleListParams;
import com.lzhijin.blog.entity.params.ArticleParams;
import com.lzhijin.blog.service.bll.ArticleBLL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 博文表 前端控制器
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-23
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends AbstractRestService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleBLL articleBLL;

    /**
     * 新增博客
     *
     * @param params 文章实体
     * @return
     * @author lzhijin
     * @since 2019-09-23
     */
    @PostMapping(value = "addArticle")
    public ResponseResult<Boolean> addArticle(ArticleParams params){
        if (params==null){
            return this.buildIllegalParamResult();
        }
        try{
            if(articleBLL.addArticle(params)){
                return this.buildSuccessResult(true);
            } else {
                return this.buildErrorResult("新增博客失败");
            }
        } catch(Exception e){
            e.printStackTrace();
            logger.error("新增博客失败: " + e.getMessage());
            return this.buildErrorResult("新增博客失败: " + e.getMessage());
        }
    }

    /**
     * 博客列表查询
     *
     * @param params 标签ID 分页参数
     * @return ArticleListDTO 文章列表实体
     * @author lzhijin
     * @since 2019-09-26
     */
    @PostMapping(value = "getArticleList")
    public ResponseResult<Page<ArticleListDTO>> getArticleList(ArticleListParams params){
        if(params.getPageNum()  < 1){
            params.setPageNum(1);
        }
        if(params.getPageSize() < 1){
            params.setPageSize(10);
        }
        try{
            return this.buildSuccessResult(articleBLL.getArticleList(params));
        } catch(Exception e){
            e.printStackTrace();
            logger.error("查询博客列表失败: " + e.getMessage());
            return this.buildErrorResult("查询博客列表失败");
        }
    }

}

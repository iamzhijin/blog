package com.lzhijin.blog.controller;


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
@RequestMapping("/blog/article")
public class ArticleController {

    /**
     * 新增博客
     *
     * @param
     * @return
     * @author lzhijin
     * @since 2019-09-23
     */
    @PostMapping(value = "addArticle")
    public Object addArticle(Object params){
        return null;
    }

}

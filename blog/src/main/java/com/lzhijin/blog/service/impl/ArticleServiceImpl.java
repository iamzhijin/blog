package com.lzhijin.blog.service.impl;

import com.lzhijin.blog.entity.Article;
import com.lzhijin.blog.mapper.ArticleMapper;
import com.lzhijin.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博文表 服务实现类
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}

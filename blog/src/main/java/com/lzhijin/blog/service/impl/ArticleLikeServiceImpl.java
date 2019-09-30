package com.lzhijin.blog.service.impl;

import com.lzhijin.blog.entity.ArticleLike;
import com.lzhijin.blog.mapper.ArticleLikeMapper;
import com.lzhijin.blog.service.IArticleLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章点赞收藏表 服务实现类
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-30
 */
@Service
public class ArticleLikeServiceImpl extends ServiceImpl<ArticleLikeMapper, ArticleLike> implements IArticleLikeService {

}

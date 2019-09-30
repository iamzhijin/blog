package com.lzhijin.blog.service.bll;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzhijin.blog.entity.Article;
import com.lzhijin.blog.entity.ArticleLike;
import com.lzhijin.blog.enums.ArticleLikeEnum;
import com.lzhijin.blog.service.IArticleLikeService;
import com.lzhijin.blog.util.TokenUtil;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleLikeBLL {

    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    IArticleLikeService articleLikeService;

    /**
     * 文章点赞或收藏
     *
     * @param params 文章id 用户行为 behavior 1点赞 2收藏
     * @return
     * @author lzhijin
     * @since 2019-09-30
     */
    public Boolean addArticleLike(ArticleLike params) throws Exception{
        String userId = tokenUtil.getLoginDto().getUserId();
        QueryWrapper<ArticleLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("article_id", params.getArticleId())
                .eq("behavior", params.getBehavior());
        ArticleLike articleLike = articleLikeService.getOne(queryWrapper);
        if(articleLike!=null){
            throw new Exception("已"+ ArticleLikeEnum.getName(params.getBehavior()) +"过该文章");
        }
        params.setUserId(userId);
        params.setId(UUIDUtil.getUUID());
        return articleLikeService.save(params);

    }
}

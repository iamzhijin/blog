package com.lzhijin.blog.service.bll;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzhijin.blog.entity.Article;
import com.lzhijin.blog.entity.ArticleLike;
import com.lzhijin.blog.enums.ArticleLikeEnum;
import com.lzhijin.blog.mapper.ArticleLikeMapper;
import com.lzhijin.blog.service.IArticleLikeService;
import com.lzhijin.blog.util.TokenUtil;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleLikeBLL {

    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    IArticleLikeService articleLikeService;
    @Resource
    ArticleLikeMapper articleLikeMapper;

    /**
     * 文章点赞或收藏
     *
     * @param params 文章id 用户行为 behavior 1点赞 2收藏
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
        if(articleLikeService.save(params)){
            articleLikeMapper.increaseArticleLike(params);
            return true;
        }
        return false;
    }

    /**
     * 取消收藏、点赞
     *
     * @param params 文章ID 用户ID
     * @return
     * @author lzhijin
     * @since 2019-10-08
     */
    public Boolean cancelArticleLike(ArticleLike params){
        String userId = tokenUtil.getLoginDto().getUserId();
        QueryWrapper<ArticleLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("article_id", params.getArticleId())
                .eq("behavior", params.getBehavior());
        if(articleLikeService.remove(queryWrapper)){
            // 文章收藏、点赞数量减1
            articleLikeMapper.decreaseArticleLike(params);
            return true;
        }
        return false;
    }

}

package com.lzhijin.blog.controller;


import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.ArticleLike;
import com.lzhijin.blog.enums.ArticleLikeEnum;
import com.lzhijin.blog.service.bll.ArticleLikeBLL;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 文章点赞收藏表 前端控制器
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-30
 */
@Controller
@RequestMapping("/articleLike")
public class ArticleLikeController extends AbstractRestService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleLikeController.class);

    @Autowired
    ArticleLikeBLL articleLikeBLL;

    /**
     * 文章点赞或收藏
     *
     * @param params 文章id 用户行为 behavior 1点赞 2收藏
     * @return
     * @author lzhijin
     * @since 2019-09-30
     */
    @PostMapping(value = "addArticleLike")
    public ResponseResult<Boolean> addArticleLike(ArticleLike params){
        if(StringUtils.isEmpty(params.getArticleId())){
            return this.buildIllegalParamResult();
        }
        if(params.getBehavior()==null){
            return this.buildErrorResult("请选择点赞或收藏");
        }
        try{
            if(articleLikeBLL.addArticleLike(params)){
                return this.buildSuccessResult(true);
            } else {
                return this.buildErrorResult(ArticleLikeEnum.getName(params.getBehavior()) + "文章失败");
            }
        } catch(Exception e){
            e.printStackTrace();
            logger.error(ArticleLikeEnum.getName(params.getBehavior()) + "文章失败: " + e.getMessage());
            return this.buildErrorResult(ArticleLikeEnum.getName(params.getBehavior()) + "文章失败: " + e.getMessage());
        }
    }

}

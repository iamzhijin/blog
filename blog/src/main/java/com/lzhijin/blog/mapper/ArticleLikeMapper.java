package com.lzhijin.blog.mapper;

import com.lzhijin.blog.entity.ArticleLike;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 文章点赞收藏表 Mapper 接口
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-30
 */
@Mapper
public interface ArticleLikeMapper extends BaseMapper<ArticleLike> {

    void increaseArticleLike(@Param("params") ArticleLike params);

    void decreaseArticleLike(@Param("params") ArticleLike params);

}

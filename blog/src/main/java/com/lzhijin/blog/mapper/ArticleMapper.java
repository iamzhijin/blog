package com.lzhijin.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzhijin.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzhijin.blog.entity.dto.ArticleListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 博文表 Mapper 接口
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-23
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleListDTO> getArticleList(@Param("labelId") String labelId, Page articlePage);

}

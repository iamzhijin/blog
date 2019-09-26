package com.lzhijin.blog.mapper;

import com.lzhijin.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}

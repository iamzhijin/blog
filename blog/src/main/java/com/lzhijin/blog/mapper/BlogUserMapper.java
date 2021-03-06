package com.lzhijin.blog.mapper;

import com.lzhijin.blog.entity.BlogUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-05
 */
@Mapper
public interface BlogUserMapper extends BaseMapper<BlogUser> {

}

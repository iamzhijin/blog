package com.lzhijin.blog.mapper;

import com.lzhijin.blog.entity.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签类型表 Mapper 接口
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-26
 */
@Mapper
public interface LabelMapper extends BaseMapper<Label> {

}

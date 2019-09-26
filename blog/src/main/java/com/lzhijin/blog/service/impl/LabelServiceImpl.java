package com.lzhijin.blog.service.impl;

import com.lzhijin.blog.entity.Label;
import com.lzhijin.blog.mapper.LabelMapper;
import com.lzhijin.blog.service.ILabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签类型表 服务实现类
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-26
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

}

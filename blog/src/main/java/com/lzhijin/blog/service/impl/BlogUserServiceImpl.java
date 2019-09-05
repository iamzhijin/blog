package com.lzhijin.blog.service.impl;

import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.mapper.BlogUserMapper;
import com.lzhijin.blog.service.IBlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-05
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

}

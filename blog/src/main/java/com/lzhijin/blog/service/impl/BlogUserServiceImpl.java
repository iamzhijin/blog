package com.lzhijin.blog.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.entity.params.LoginParams;
import com.lzhijin.blog.mapper.BlogUserMapper;
import com.lzhijin.blog.service.IBlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzhijin.blog.util.MD5Util;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

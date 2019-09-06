package com.lzhijin.blog.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.mapper.BlogUserMapper;
import com.lzhijin.blog.service.IBlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    /**
     * 下发登录后的token
     *
     * @param blogUser 用户参数
     * @return token 令牌
     */
    public String createToken(BlogUser blogUser){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;
        Date end = new Date(currentTime);
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");
        return JWT.create()
                .withHeader(headerMap)
                .withAudience(blogUser.getId())  // 受众
                .withIssuedAt(start)  // 签发时间
                .withExpiresAt(end)  // 过期时间
                .sign(Algorithm.HMAC256(blogUser.getPassword()));
    }

}

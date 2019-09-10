package com.lzhijin.blog.service.bll;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.entity.dto.LoginDTO;
import com.lzhijin.blog.entity.params.LoginParams;
import com.lzhijin.blog.service.IBlogUserService;
import com.lzhijin.blog.util.MD5Util;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BlogUserBLL {

    @Autowired
    IBlogUserService blogUserService;

    /**
     * 用户注册
     *
     * @param params 注册参数
     * @return UUID 用户ID
     * @author lzhijin
     * @since 2019-09-10
     */
    public String register(LoginParams params) throws Exception{
        // 验证手机号码是否注册过
        if(!checkPhone(params.getPhone())){
            throw new Exception("手机号已注册！");
        }
        BlogUser blogUser = new BlogUser();
        String UUID = UUIDUtil.getUUID();
        blogUser.setId(UUID);
        blogUser.setPhone(params.getPhone());
        blogUser.setPassword(MD5Util.MD5(params.getPassword()));
        if(blogUserService.save(blogUser)){
            return UUID;
        }
        return null;
    }

    /**
     * 登录
     *
     * @param params 登录参数
     * @return BlogUser 用户详细信息
     * @author lzhijin
     * @since 2019-09-06
     */
    public LoginDTO login(LoginParams params) throws Exception{
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", params.getPhone());
        BlogUser blogUser = blogUserService.getOne(queryWrapper);
        if(blogUser==null){
            throw new Exception("用户不存在");
        }
        // 验证密码
        if(params.getPassword().equals(blogUser.getPassword())){
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setPhone(params.getPhone());
            loginDTO.setUserId(blogUser.getId());
            loginDTO.setToken(createToken(blogUser));
            return loginDTO;
        } else {
            throw new Exception("密码错误，请检查");
        }
    }

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

    private Boolean checkPhone(String phone){
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PHONE", phone);
        BlogUser blogUser = blogUserService.getOne(queryWrapper);
        return blogUser==null;
    }
}

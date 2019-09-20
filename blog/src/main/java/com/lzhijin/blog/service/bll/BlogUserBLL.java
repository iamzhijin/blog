package com.lzhijin.blog.service.bll;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.entity.dto.LoginDTO;
import com.lzhijin.blog.entity.params.LoginParams;
import com.lzhijin.blog.service.IBlogUserService;
import com.lzhijin.blog.util.MD5Util;
import com.lzhijin.blog.util.TokenUtil;
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
    @Autowired
    TokenUtil tokenUtil;

    /**
     * 用户注册
     *
     * @param params 注册参数
     * @return UUID 用户ID
     * @author lzhijin
     * @since 2019-09-10
     */
    public boolean register(BlogUser params) throws Exception{
        // 验证手机号码是否注册过
        if(!checkPhone(params.getPhone())){
            throw new Exception("手机号已注册！");
        }
        String UUID = UUIDUtil.getUUID();
        params.setId(UUID);
        return blogUserService.save(params);
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
            loginDTO.setPhone(blogUser.getPhone());
            loginDTO.setUserId(blogUser.getId());
            loginDTO.setName(blogUser.getName());
            loginDTO.setToken(tokenUtil.createToken(blogUser));
            return loginDTO;
        } else {
            throw new Exception("密码错误，请检查");
        }
    }

    /**
     * 查询用户详情
     *
     * @param id 用户id
     * @return BlogUser 用户类
     * @author lzhijin
     * @since 2019-09-20
     */
    public BlogUser getUserInfo(String id){
        return blogUserService.getById(id);
    }

    /**
     * 校验用户号码是否已注册
     *
     * @param phone 手机号码
     * @return true/false
     */
    private Boolean checkPhone(String phone){
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        BlogUser blogUser = blogUserService.getOne(queryWrapper);
        return blogUser==null;
    }
}

package com.lzhijin.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.entity.dto.LoginDTO;
import com.lzhijin.blog.entity.params.LoginParams;
import com.lzhijin.blog.service.IBlogUserService;
import com.lzhijin.blog.service.bll.BlogUserBLL;
import com.lzhijin.blog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-05
 */
@RestController
@RequestMapping("/user")
public class BlogUserController extends AbstractRestService {

    @Autowired
    BlogUserBLL blogUserBLL;

    /**
     * 用户注册
     *
     * @param params 注册参数
     * @return
     * @author lzhijin
     * @since 2019-09-10
     */
    @PostMapping(value = "/register")
    public ResponseResult<String> register(@RequestBody LoginParams params){
        if(params==null || StringUtils.isEmpty(params.getPassword())){
            return this.buildIllegalParamResult();
        }
        try{
            return this.buildSuccessResult(blogUserBLL.register(params));
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 登录
     *
     * @param params 登录参数
     * @return LoginDTO 登录结果
     * @author lzhijin
     * @since 2019-09-06
     */
    @PostMapping(value = "/login")
    public ResponseResult<LoginDTO> login(LoginParams params){
        if(params==null || params.getPhone()==null){
            return this.buildIllegalParamResult();
        }
        try{
            return this.buildSuccessResult(blogUserBLL.login(params));
        } catch(Exception e){
            e.printStackTrace();
            return this.buildErrorResult("登录失败：" + e.getMessage());
        }
    }

}

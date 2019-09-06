package com.lzhijin.blog.controller;


import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.entity.params.LoginParams;
import com.lzhijin.blog.util.UUIDUtil;
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
@RequestMapping("/blog")
public class BlogUserController extends AbstractRestService {

    /**
     * 登录
     *
     * @param params 登录参数
     * @return
     * @author lzhijin
     * @since 2019-09-06
     */
    @PostMapping(value = "/login")
    public ResponseResult login(LoginParams params){
        BlogUser blogUser = new BlogUser();
        blogUser.setId(UUIDUtil.getUUID());
        blogUser.setName("admin");
        blogUser.setPassword("admin");
        // 验证用户是否存在

        // 验证密码
        if(params.getPassword().equals(blogUser.getPassword())){
            this.buildErrorResult("密码错误");
        } else {
            return this.buildErrorResult("密码错误");
        }

        return null;
    }

}

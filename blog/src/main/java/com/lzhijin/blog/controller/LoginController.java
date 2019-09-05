package com.lzhijin.blog.controller;

import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.dto.LoginDto;
import com.lzhijin.blog.entity.params.LoginParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录前端控制器
 */
@RestController
@RequestMapping("/user")
public class LoginController extends AbstractRestService {

    @PostMapping("login")
    public ResponseResult<LoginDto> login(LoginParams params){
        if(params==null){
            return this.buildIllegalParamResult();
        }
        return null;
    }

}

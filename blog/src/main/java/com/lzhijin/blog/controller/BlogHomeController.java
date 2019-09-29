package com.lzhijin.blog.controller;

import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.entity.dto.IsLoginDTO;
import com.lzhijin.blog.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class BlogHomeController extends AbstractRestService {

    @Autowired
    TokenUtil tokenUtil;

    /**
     * 主页
     *
     * @param
     * @return
     * @author lzhijin
     * @since 2019-09-19
     */
    @PostMapping(value = "home")
    public ResponseResult home(){
        IsLoginDTO isLoginDTO = tokenUtil.isLogin();
        if(!isLoginDTO.isLogin()){
            return this.buildUnLoginResult(isLoginDTO.getCode(), isLoginDTO.getMessage());
        }
        return this.buildSuccessResult("success");
    }

}

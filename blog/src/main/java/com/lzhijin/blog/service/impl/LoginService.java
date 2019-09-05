package com.lzhijin.blog.service.impl;

import com.lzhijin.blog.entity.dto.LoginDto;
import com.lzhijin.blog.entity.params.LoginParams;
import com.lzhijin.blog.service.ILoginService;

public class LoginService implements ILoginService {

    @Override
    public LoginDto login(LoginParams params) throws Exception{
        if(!"15372022952".equals(params.getPhone())){
            throw new Exception("用户不存在");
        }

        if(!"123456".equals(params.getPassword())){
            throw new Exception("密码错误");
        }
        return null;
    }
}

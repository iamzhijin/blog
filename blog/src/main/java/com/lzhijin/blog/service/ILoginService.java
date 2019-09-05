package com.lzhijin.blog.service;

import com.lzhijin.blog.entity.dto.LoginDto;
import com.lzhijin.blog.entity.params.LoginParams;

public interface ILoginService {
    /**
     * 登录
     * @param params
     * @return
     */
    LoginDto login(LoginParams params) throws Exception;
}

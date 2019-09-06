package com.lzhijin.blog.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lzhijin.blog.entity.BlogUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

public class TokenUtil {


    /**
     * 通过TOKEN 获取userId
     *
     * @return userId
     */
    public static String getTokenUserId(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        String userId = "";
        if(requestAttributes!=null){
            String token = requestAttributes.getRequest().getHeader("token");
            userId = JWT.decode(token).getAudience().get(0);
        }
        return userId;
    }

}

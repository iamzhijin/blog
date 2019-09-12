package com.lzhijin.blog.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lzhijin.blog.entity.BlogUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    /**
     * 签发登录后的token
     *
     * @param blogUser 用户参数
     * @return token 令牌
     */
    public static String createToken(BlogUser blogUser){
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
                .sign(Algorithm.HMAC256(blogUser.getPassword()));  // 密码设置到签名中
    }

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

    /**
     * 重header中获取token
     * @return token
     */
    public static String getTokenFromHeader(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(requestAttributes!=null){
            return requestAttributes.getRequest().getHeader("token");
        }
        return null;
    }

    public static Boolean isLogin(){
        String token = getTokenFromHeader();
        if(token!=null){
            String password = JWT.decode(token).getSignature();
        }
    }

}

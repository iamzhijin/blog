package com.lzhijin.blog.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lzhijin.blog.common.LoginRequired;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.service.IBlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    IBlogUserService blogUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(LoginRequired.class)){
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            if(loginRequired.required()){
                // 执行认证
                if(token == null){
                    throw new Exception("无token信息，请登录");
                }
                String userId = JWT.decode(token).getAudience().get(0);
                BlogUser blogUser = blogUserService.getById(userId);
                if(blogUser == null){
                    throw new Exception("用户不存在，请重新登录");
                }
                // 验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(blogUser.getPassword())).build();
                try{
                    jwtVerifier.verify(token);
                } catch(JWTVerificationException e){
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

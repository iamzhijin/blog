package com.lzhijin.blog.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lzhijin.blog.common.AbstractRestService;
import com.lzhijin.blog.common.ResponseResult;
import com.lzhijin.blog.common.SecretConstant;
import com.lzhijin.blog.entity.BlogUser;
import com.lzhijin.blog.entity.dto.IsLoginDTO;
import com.lzhijin.blog.entity.dto.LoginDTO;
import com.lzhijin.blog.enums.ResponseCodeEnum;
import com.lzhijin.blog.service.IBlogUserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    @Autowired
    IBlogUserService blogUserService;

    /**
     * 签发登录后的token
     *
     * @param blogUser 用户参数
     * @return token 令牌
     */
    public String createToken(BlogUser blogUser){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;  // 签名算法--HS256
        long nowTimeMillis = System.currentTimeMillis();
        Date now = new Date(nowTimeMillis);
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SecretConstant.SECRET_KEY); // 将密匙常量解码成base64字节组
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());  //生成一个HS256的签名秘钥Key  ？
        Map<String, Object> headerMap = new HashMap<>();  // 添加header参数
        headerMap.put("alg", signatureAlgorithm.getValue());
        headerMap.put("typ", "JWT");
        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .claim("userId", blogUser.getId())
                .claim("userName", blogUser.getName())
                .signWith(signatureAlgorithm, signingKey);
        if(SecretConstant.EXPIRATION > 0){
            long expMillis = nowTimeMillis + SecretConstant.EXPIRATION;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate).setNotBefore(now);
        }
        return builder.compact();
    }

    /**
     * 解析token
     *
     * @param token JWT token
     * @return Claims对象
     * @exception throws SignatureException token非法， ExpiredJwtException token过期
     */
    private Claims parseJWT(String token) throws SignatureException, ExpiredJwtException{
            return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SecretConstant.SECRET_KEY))  // 为什么不需要指定解密算法
                    .parseClaimsJws(token).getBody();
    }

    /**
     * 校验token
     *
     * @return LoginDTO 用户登录信息响应类
     */
    public IsLoginDTO isLogin(){
        String token = getTokenFromHeader();
        IsLoginDTO isLoginDTO = new IsLoginDTO();
        if(StringUtils.isEmpty(token)){
            isLoginDTO.setLogin(false);
            isLoginDTO.setCode(ResponseCodeEnum.UNLOGIN.getCode());
            isLoginDTO.setMessage(ResponseCodeEnum.UNLOGIN.getName());
            return isLoginDTO;
        }
        try{
            Claims claims = parseJWT(token);
            isLoginDTO.setLogin(true);
            isLoginDTO.setCode(ResponseCodeEnum.SUCCESS.getCode());
            isLoginDTO.setMessage(ResponseCodeEnum.SUCCESS.getName());
            return isLoginDTO;
        } catch(SignatureException sigEor){ // token 错误
            isLoginDTO.setLogin(false);
            isLoginDTO.setCode(ResponseCodeEnum.TOKEN_ERROR.getCode());
            isLoginDTO.setMessage(ResponseCodeEnum.TOKEN_ERROR.getName());
            return isLoginDTO;
        } catch(ExpiredJwtException expEro){  // token过期
            isLoginDTO.setLogin(false);
            isLoginDTO.setCode(ResponseCodeEnum.TOKEN_EXPIRATION.getCode());
            isLoginDTO.setMessage(ResponseCodeEnum.TOKEN_EXPIRATION.getName());
            return isLoginDTO;
        }
    }

    /**
     * 根据token获取当前登录对象
     */

    /**
     * 从header中获取token
     * @return token
     */
    private String getTokenFromHeader(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(requestAttributes!=null){
            return requestAttributes.getRequest().getHeader("token");
        }
        return null;
    }

}

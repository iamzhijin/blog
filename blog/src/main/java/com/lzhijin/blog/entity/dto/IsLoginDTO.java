package com.lzhijin.blog.entity.dto;

public class IsLoginDTO {

    /** 是否登录 true/false */
    private boolean isLogin;

    /** 响应码 */
    private Integer code;

    /** 登录失败的具体原因 */
    private String message;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

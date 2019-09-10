package com.lzhijin.blog.entity.dto;

public class LoginDTO {
    /** 用户ID */
    private String userId;

    /** 登录token */
    private String token;

    /** 电话号码 */
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

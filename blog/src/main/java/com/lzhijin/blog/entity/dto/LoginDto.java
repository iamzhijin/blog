package com.lzhijin.blog.entity.dto;

public class LoginDto {
    /** 用户ID */
    private String userId;

    /** 登录token */
    private String token;

    /** 电话号码 */
    private String phone;

    /** 密码 */
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

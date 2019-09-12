package com.lzhijin.blog.entity.dto;

public class LoginDTO {
    /** 用户ID */
    private String userId;

    /** 登录token */
    private String token;

    /** 电话号码 */
    private String phone;

    /** 用户姓名 */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

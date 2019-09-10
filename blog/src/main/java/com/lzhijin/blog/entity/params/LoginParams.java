package com.lzhijin.blog.entity.params;

public class LoginParams {
    /** 电话号码 */
    private Integer phone;

    /** 密码 */
    private String password;

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

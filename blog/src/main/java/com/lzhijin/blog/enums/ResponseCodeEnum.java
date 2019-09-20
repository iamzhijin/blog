package com.lzhijin.blog.enums;

/**
 * 响应类型编码
 */
public enum ResponseCodeEnum {
    SUCCESS(1000, "请求成功"),
    UNLOGIN(1001, "未登录"),
    TOKEN_ERROR(1002, "token 错误"),
    TOKEN_EXPIRATION(1003, "token 过期")
    ;

    private final Integer code;

    private final String name;

    ResponseCodeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举名称
     *
     * @param code 序号
     * @return
     */
    public static String getName(int code) {
        for (ResponseCodeEnum enums : values()) {
            if (code == enums.getCode()) {
                return enums.getName();
            }
        }
        return null;
    }
}

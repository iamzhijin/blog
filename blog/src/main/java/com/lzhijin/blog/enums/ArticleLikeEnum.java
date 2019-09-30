package com.lzhijin.blog.enums;

public enum ArticleLikeEnum {
    LIKE(1, "点赞"),
    COLLECTION(2, "收藏"),
    ;

    /** 编码 */
    private final Integer code;

    /** 名称 */
    private final String name;

    ArticleLikeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getName(int code){
        for(ArticleLikeEnum enums : values()){
            if(code == enums.getCode()){
                return enums.getName();
            }
        }
        return null;
    }
}

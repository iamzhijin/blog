package com.lzhijin.blog.common;

public class ResponseResult<T> {
    /** 状态 0-失败，1-成功*/
    private int status;

    /** 结果编码 */
    private int code;

    /** 返回内容 */
    private T content;

    /** 返回消息 */
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.lzhijin.blog.common;

/**
 * 接口结果抽象类
 */
public abstract class AbstractRestService {

    /**
     * 返回错误对象信息
     */
    protected <T> ResponseResult<T> buildErrorResult(int code, String message){
        ResponseResult<T> serviceResult = new ResponseResult<T>();
        serviceResult.setCode(code);
        serviceResult.setMessage(message);
        serviceResult.setStatus(0);
        return serviceResult;
    }

    protected <T> ResponseResult<T>buildErrorResult(String message){
        ResponseResult<T> serviceResult = new ResponseResult<>();
        serviceResult.setMessage(message);
        serviceResult.setStatus(0);
        return serviceResult;
    }

    /**
     * 返回参数非法对象信息
     */
    protected <T> ResponseResult<T> buildIllegalParamResult(){
        ResponseResult<T> serviceResult = new ResponseResult<T>();
        serviceResult.setMessage("参数非法");
        serviceResult.setStatus(0);
        return serviceResult;
    }

    /**
     * 创建会话过期的结果
     */
    protected  <T> ResponseResult<T> buildUnLoginResult() {
        ResponseResult<T> serviceResult = new ResponseResult<T>();
        serviceResult.setStatus(2);
        serviceResult.setMessage("未登录");
        return serviceResult;
    }

    /**
     * 创建会话过期的结果
     */
    protected  <T> ResponseResult<T> buildUnLoginResult(int code, String message) {
        ResponseResult<T> serviceResult = new ResponseResult<T>();
        serviceResult.setStatus(2);
        serviceResult.setMessage(message);
        return serviceResult;
    }

    /**
     * 创建成功结果
     */
    protected <T> ResponseResult<T> buildSuccessResult(T data){
        ResponseResult<T> serviceResult = new ResponseResult<T>();
        serviceResult.setStatus(1);
        serviceResult.setContent(data);
        return serviceResult;
    }
}

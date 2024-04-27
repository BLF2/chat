package com.blf2.chat.common;

import org.springframework.util.StringUtils;

/**
 * 返回通用类型
 */
public class ResultBase<T> {

    private String code;

    private String msg;

    private T data;

    public ResultBase() {
    }

    public ResultBase(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBase(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultBase<T> success(){
        return new ResultBase<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),null);
    }

    public static <T> ResultBase<T> success(T data){
        return new ResultBase<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }

    public static <T> ResultBase<T> fail(String msg){
        return new ResultBase<>(ResultEnum.FAIL.getCode(), StringUtils.hasText(msg) ? msg : ResultEnum.FAIL.getMsg(),null);
    }

    public static <T> ResultBase<T> buildResult(String code,String msg,T data){
        return new ResultBase<>(code,msg,data);
    }
}

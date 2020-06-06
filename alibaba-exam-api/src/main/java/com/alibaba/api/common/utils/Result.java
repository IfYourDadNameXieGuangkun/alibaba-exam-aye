package com.alibaba.api.common.utils;

import com.alibaba.api.common.enums.ResultCode;

public class Result<T> {
    private int code;
    private String msg;
    private T data;


    private Result() {

    }
    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    /**
     * 成功时候的调用
     *
     * @return
     */
    public static Result SUCCESS() {
        return new Result(ResultCode.SUCCESS,"success");
    }

    public static Result SUCCESS(String msg) {
        return new Result(ResultCode.SUCCESS,msg);
    }

    public static <T>Result<T> SUCCESS(String msg,T data) {
        return new Result(ResultCode.SUCCESS,msg,data);
    }

    public static <T>Result<T> SUCCESS(T data) {
        return new Result(ResultCode.SUCCESS,"success",data);
    }


    /**
     * 失败时候的调用
     *
     * @return
     */
    public static Result FAIL() {
        return new Result(ResultCode.FAIL,"FAIL");
    }

    public static Result FAIL(String msg) {
        return new Result(ResultCode.FAIL,msg);
    }





    public int getResultCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }

}

package com.alibaba.api.common.utils.exception;

public interface BaseErrorInfoInterface {
    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}

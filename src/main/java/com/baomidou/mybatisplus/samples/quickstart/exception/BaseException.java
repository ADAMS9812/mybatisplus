package com.baomidou.mybatisplus.samples.quickstart.exception;

import com.baomidou.mybatisplus.samples.quickstart.constants.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException  {

    /**
     * 错误编码
     */
    private int code;

    /**
     * 错误详情信息
     */
    private String msg;

    /**
     * 展示给前端的信息
     */
    private String frontMessage;

    private Object data;

    private transient ResponseEnum responseEnum;

    private BaseException() {}

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ResponseEnum code, Object data) {
        this(code);
        this.data = data;
    }

    public BaseException(ResponseEnum response) {
        this.responseEnum = response;
        this.code = response.getCode();
        this.msg = response.getMessage();
        this.frontMessage = response.getMessage();
    }

    public BaseException(ResponseEnum response, String ext) {
        this.responseEnum = response;
        this.code = response.getCode();
        this.frontMessage = response.getMessage();
        this.msg = ext + ", " + response.getMessage();
    }

}
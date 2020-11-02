package com.moli.reponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -875864042638324305L;

    private static final int SUCCESS_CODE = 200;
    private static final int FAIL_CODE = -1;
    private static final int STATUS_404 = 404;
    private static final int STATUS_500 = 500;
    private static final int STATUS_PROTECTED = 1000;


    private T data;
    private int code;
    private String message;

    public Result(T data) {
        this.setData(data);
    }

    public Result(T data, int code) {
        this.setData(data);
        this.code = code;
    }

    public Result(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public static <T> Result<T> success() {
        return new Result(SUCCESS_CODE);
    }


    public static <T> Result<T> success(T t) {
        return new Result(t, SUCCESS_CODE);
    }

    public static <T> Result<T> success(T t, String message) {
        return new Result(t, SUCCESS_CODE, message);
    }

    public static <T> Result<T> success(T t, int code) {
        return new Result(t, code);
    }

    public static <T> Result<T> success(T t, int code, String message) {
        return new Result(t, code, message);
    }

}


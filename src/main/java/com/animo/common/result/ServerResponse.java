package com.animo.common.result;

import com.animo.common.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/7/4
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;


    ServerResponse(Integer code) {
        this.code = code;
    }

    ServerResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ServerResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    ServerResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    @JsonIgnore
    //不会序列化
    public boolean isSuccess() {
        return this.code.equals(ResultEnum.SUCCESS.getCode());
    }


    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResultEnum.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccess(String message) {
        return new ServerResponse<T>(ResultEnum.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResultEnum.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String message, T data) {
        return new ServerResponse<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getType());
    }

    public static <T> ServerResponse<T> createByError(String message) {
        return new ServerResponse<T>(ResultEnum.ERROR.getCode(), message);
    }

    public static <T> ServerResponse<T> createByError(Integer code, String message) {
        return new ServerResponse<T>(code, message);
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}


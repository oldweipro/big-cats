package com.ultronvision.bigcats.common.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 接口返回统一数据格式
 *
 * @author oldwei
 * @date 2022-2-9 09:48
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class ResultResponse<T> implements Serializable {
    private static final long serialVersionUID = 7800153126387826029L;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public static<T> ResultResponse<T> ok() {
        ResultResponse<T> r = new ResultResponse<T>();
        r.setSuccess(true);
        r.setCode(HttpStatus.OK.value());
        return r;
    }

    public static<T> ResultResponse<T> ok(String message) {
        ResultResponse<T> r = new ResultResponse<T>();
        r.setMessage(message);
        r.setCode(HttpStatus.OK.value());
        r.setSuccess(true);
        return r;
    }

    public static<T> ResultResponse<T> ok(T data) {
        ResultResponse<T> r = new ResultResponse<T>();
        r.setSuccess(true);
        r.setCode(HttpStatus.OK.value());
        r.setResult(data);
        return r;
    }

    public static<T> ResultResponse<T> ok(String msg, T data) {
        ResultResponse<T> r = new ResultResponse<T>();
        r.setSuccess(true);
        r.setCode(HttpStatus.OK.value());
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static<T> ResultResponse<T> error(int code, String msg) {
        ResultResponse<T> r = new ResultResponse<>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public static<T> ResultResponse<T> error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static<T> ResultResponse<T> error(String msg, T data) {
        ResultResponse<T> r = new ResultResponse<>();
        r.setSuccess(false);
        r.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }
}

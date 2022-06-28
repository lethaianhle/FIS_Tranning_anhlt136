package com.fis.app.core;

import com.fis.app.enums.ResultEnums;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class Result<T> implements Serializable {

    int code;

    String message;

    Object data;

    public Result() {
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultEnums resultEnums) {
        this.data = null;
        this.code = resultEnums.getCode();
        this.message = resultEnums.getMessage();
    }

    public Result(ResultEnums resultEnums, Object data) {
        this.data = data;
        this.code = resultEnums.getCode();
        this.message = resultEnums.getMessage();
    }

    public static <T> Result<T> error(String msg) {
        log.debug("ERROR：code={}, msg={}", ResultEnums.ERROR.getCode(), msg);
        return new Result<T>(ResultEnums.ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> error(ResultEnums resultEnum) {
        log.debug("ERROR：code={}, msg={}", resultEnum.getCode(), resultEnum.getMessage());
        return new Result<T>(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static <T> Result<T> error(int code, String msg) {
        log.debug("ERROR：code={}, msg={}", code, msg);
        return new Result<T>(code, msg, null);
    }

    public static <T> Result<T> fail(String msg) {
        log.debug("ERROR：code={}, msg={}", ResultEnums.FAIL.getCode(), msg);
        return new Result<T>(ResultEnums.FAIL.getCode(), msg, null);
    }

    public static <T> Result<T> fail(ResultEnums resultEnums, String msg) {
        log.debug("ERROR：code={}, msg={}", resultEnums.getCode(), msg);
        return new Result<T>(ResultEnums.BAD_REQUEST.getCode(), msg, null);
    }

    public static <T> Result<T> paramInvalid() {
        log.debug("ERROR：code={}, msg={}", ResultEnums.PARAM_INVALID_ERROR.getCode(), ResultEnums.PARAM_INVALID_ERROR.getMessage());
        return new Result<T>(ResultEnums.PARAM_INVALID_ERROR);
    }

    public static <T> Result<T> paramInvalid(String msg) {
        log.debug("ERROR：code={}, msg={}", ResultEnums.PARAM_INVALID_ERROR.getCode(), msg);
        return new Result<T>(ResultEnums.PARAM_INVALID_ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> success(Object data) {
        return new Result<T>(ResultEnums.SUCCESS.getCode(), "OK", (T) data);
    }

    public static <T> Result<T> success(Object data, ResultEnums resultEnums) {
        return new Result<T>(resultEnums.getCode(), resultEnums.getMessage(), (T) data);
    }

    public static <T> Result<T> success(Object data, String msg) {
        return new Result<T>(ResultEnums.SUCCESS.getCode(), msg, (T) data);
    }

}

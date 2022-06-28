package com.fis.app.exception.handler;

import com.fis.app.core.Result;
import com.fis.app.enums.ResultEnums;
import com.fis.app.exception.CustomerNotFoundException;
import com.fis.app.exception.ParamInvalidException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected Result<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(ex -> {
            errorMap.put(ex.getField(), ex.getDefaultMessage());
        });
        return Result.error(String.valueOf(errorMap));
    }

//
//    @ExceptionHandler(ParamInvalidException.class)
//    protected Result<Object> handleParamInvalidException(ParamInvalidException ex) {
//        return Result.error(ResultEnums.PARAM_INVALID_ERROR.getCode(), ex.getMessage());
//    }

}

package com.fis.app.exception.handler;

import com.fis.app.core.Result;
import com.fis.app.enums.ResultEnums;
import com.fis.app.exception.CustomerNotFoundException;
import com.fis.app.exception.ParamInvalidException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = {BindException.class})
//    protected Result<Object> handleBindException(BindException e) {
//        return Result.fail(ResultEnums.BAD_REQUEST, e.getMessage());
//    }

//    @ExceptionHandler(CustomerNotFoundException.class)
//    protected Result<Object> handleCustomerNotFoundException(CustomerNotFoundException ex) {
//        return Result.error(ResultEnums.ITEM_NOT_FOUND_ERROR.getCode(), ex.getMessage());
//    }
//
//    @ExceptionHandler(ParamInvalidException.class)
//    protected Result<Object> handleParamInvalidException(ParamInvalidException ex) {
//        return Result.error(ResultEnums.PARAM_INVALID_ERROR.getCode(), ex.getMessage());
//    }

}

package com.fis.app.exception;

import com.fis.app.core.CoreException;
import com.fis.app.enums.ResultEnums;

public class OrderItemNotFoundException extends CoreException {

    public OrderItemNotFoundException() {
        super(ResultEnums.ITEM_NOT_FOUND_ERROR.getMessage());
        this.code = ResultEnums.ITEM_NOT_FOUND_ERROR.getCode();
    }

    public OrderItemNotFoundException(String message) {
        super(message);
        this.code = ResultEnums.ITEM_NOT_FOUND_ERROR.getCode();
    }

}

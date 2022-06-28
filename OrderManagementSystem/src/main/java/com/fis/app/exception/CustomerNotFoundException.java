package com.fis.app.exception;

import com.fis.app.core.CoreException;
import com.fis.app.enums.ResultEnums;

public class CustomerNotFoundException extends CoreException {

    public CustomerNotFoundException() {
        super(ResultEnums.ITEM_NOT_FOUND_ERROR.getMessage());
        this.code = ResultEnums.ITEM_NOT_FOUND_ERROR.getCode();
    }

    public CustomerNotFoundException(String message) {
        super(message);
        this.code = ResultEnums.ITEM_NOT_FOUND_ERROR.getCode();
    }

}

package com.fis.app.exception;

import com.fis.app.core.CoreException;
import com.fis.app.enums.ResultEnums;

public class ProductQuantityNotEnoughException extends CoreException {

    public ProductQuantityNotEnoughException() {
        super(ResultEnums.PARAM_INVALID_ERROR.getMessage());
        this.code = ResultEnums.PARAM_INVALID_ERROR.getCode();
    }

    public ProductQuantityNotEnoughException(String message) {
        super(message);
        this.code = ResultEnums.PARAM_INVALID_ERROR.getCode();
    }

}

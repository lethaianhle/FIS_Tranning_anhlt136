package fis.training.exception;

import fis.training.core.CoreException;
import fis.training.enums.ResultEnums;

public class ParamInvalidException extends CoreException {

    public ParamInvalidException() {
        super(ResultEnums.PARAM_INVALID_ERROR.getMessage());
        this.code = ResultEnums.PARAM_INVALID_ERROR.getCode();
    }

    public ParamInvalidException(String msg) {
        super(msg);
        this.code = ResultEnums.PARAM_INVALID_ERROR.getCode();
    }

}

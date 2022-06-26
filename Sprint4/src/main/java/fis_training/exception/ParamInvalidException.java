package fis_training.exception;

import fis_training.core.CoreException;
import fis_training.enums.ResultEnums;

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

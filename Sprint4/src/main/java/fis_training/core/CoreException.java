package fis_training.core;

import fis_training.enums.ResultEnums;
import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {

    protected int code;

    public CoreException() {
        super("SYSTEM_ERROR");
        this.code = 99;
    }

    public CoreException(ResultEnums resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public CoreException(String message) {
        super(message);
        this.code = 99;
    }

    public CoreException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

package fis_training.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnums {

    UNAUTHORIZED(401, "OK"),

    SUCCESS(200, "OK"),

    LOGIN_ERROR(303, "Login Error"), REMOTE_ERROR(304, "Remote Error"),

    ITEM_EXIST_ERROR(305, "ITEM_EXIST_ERROR"),

    ITEM_NOT_FOUND_ERROR(306, "ITEM_NOT_FOUND_ERROR"),

    PARAM_INVALID_ERROR(307, "PARAM_INVALID_ERROR"),

    NO_REG(310, "NO_REG"),

    FAIL(311, "FAIL"),

    SERVICE_ABNORMAL(99, "Dịch vụ đang bận"),

    OUT_OFF_MEMORY(312, "Hết tài nguyên hệ thống"),

    ACCOUNT_NOT_FOUND(501, "Tài khoản không có trong hệ sinh thái"),

    ERROR(999, "Hệ thống bận vui lòng thử lại sau!");

    private int code;

    private String message;

}

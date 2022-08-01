package org.li.springboot_examples.entity;

import lombok.Data;
import lombok.Getter;


@Getter
public enum ErrorCodeEnum {
    SUCCESS("0", "success"),
    FAIL("-1", "FAIL"),
    UNKNOWN_ERROR("100001", "系统异常,请稍后重试");

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;
}

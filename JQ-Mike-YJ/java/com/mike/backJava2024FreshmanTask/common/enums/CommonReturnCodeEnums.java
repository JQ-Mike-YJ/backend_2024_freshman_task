package com.mike.backJava2024FreshmanTask.common.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 返回状态码枚举
 */
@Getter
public enum CommonReturnCodeEnums {

    SUCCESS(200, "success"),
    AUTH_FAIL(208, "authentication fail"),
    FAIL(401, "fail"),
    ;

    private final Integer code;
    private final String status;

    CommonReturnCodeEnums(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    /**
     * 根据 code 获取 status
     *
     * @param code 编码
     * @return 状态
     */
    public static String getStatusByCode(Integer code) {
        for (CommonReturnCodeEnums statusEnum : CommonReturnCodeEnums.values()) {
            if (Objects.equals(statusEnum.code, code)) {
                return statusEnum.getStatus();
            }
        }
        return "";
    }
}

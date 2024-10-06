package com.mike.backJava2024FreshmanTask.common.enums;

import lombok.Getter;

/**
 * 状态枚举
 */
@Getter
public enum StatusEnums {

    INVALID(0, "无效"),
    VALID(1, "有效"),
    ;

    private final Integer code;
    private final String name;

    StatusEnums(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}

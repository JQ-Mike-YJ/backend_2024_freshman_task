package com.mike.backJava2024FreshmanTask.common.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 用户性别枚举
 */
@Getter
public enum UserGenderEnums {

    UN_KNOW(0, "未知"),
    MAIL(1, "男"),
    FEMALE(2, "女"),
    ;

    private final Integer code;
    private final String name;

    UserGenderEnums(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据 code 获取 name
     *
     * @param code 编码
     * @return 名称
     */
    public static String getNameByCode(Integer code) {
        for (UserGenderEnums statusEnum : UserGenderEnums.values()) {
            if (Objects.equals(statusEnum.code, code)) {
                return statusEnum.getName();
            }
        }
        return "";
    }
}

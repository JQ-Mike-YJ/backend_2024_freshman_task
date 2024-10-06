package com.mike.backJava2024FreshmanTask.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户信息相关请求参数
 * </p>
 *
 * @author Mike
 * @since 2024-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfoReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    private String userCode;

}

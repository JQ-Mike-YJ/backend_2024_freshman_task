package com.mike.backJava2024FreshmanTask.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * user_info
 *
 * @author
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户唯一编号
     */
    private String code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别（0-未知 1-男 2-女）
     */
    private Integer gender;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 权限身份（0-普通 1-管理员）
     */
    private Integer permissionIdentity;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录状态（0-未登录 1-已登录）
     */
    private Integer loginStatus;

    /**
     * 状态（0-失效 1-有效）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}
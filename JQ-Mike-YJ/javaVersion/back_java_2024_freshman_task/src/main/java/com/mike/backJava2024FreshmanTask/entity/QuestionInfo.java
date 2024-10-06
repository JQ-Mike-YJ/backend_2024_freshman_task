package com.mike.backJava2024FreshmanTask.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * question_info
 *
 * @author
 */
@Data
public class QuestionInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 问题描述
     */
    private String questionDesc;

    /**
     * 创建人编号
     */
    private String creatorCode;

    /**
     * 创建人姓名
     */
    private String creatorName;

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
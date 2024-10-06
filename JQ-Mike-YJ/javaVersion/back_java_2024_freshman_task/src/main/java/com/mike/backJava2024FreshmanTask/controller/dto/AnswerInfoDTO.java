package com.mike.backJava2024FreshmanTask.controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 答案 DTO
 */
@Data
public class AnswerInfoDTO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 问题ID
     */
    private Long questionId;

    /**
     * 问题解答
     */
    private String answer;

    /**
     * 完美答案（0-否 1-是）
     */
    private Integer isPerfectAnswer;

    /**
     * 权重
     */
    private BigDecimal weight;

    /**
     * 创建人编号
     */
    private String creatorCode;

    /**
     * 创建人姓名
     */
    private String creatorName;

    private static final long serialVersionUID = 1L;
}
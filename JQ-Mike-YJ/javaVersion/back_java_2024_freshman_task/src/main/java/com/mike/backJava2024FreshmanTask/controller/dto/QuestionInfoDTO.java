package com.mike.backJava2024FreshmanTask.controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 问题 DTO
 */
@Data
public class QuestionInfoDTO implements Serializable {
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

    private static final long serialVersionUID = 1L;
}
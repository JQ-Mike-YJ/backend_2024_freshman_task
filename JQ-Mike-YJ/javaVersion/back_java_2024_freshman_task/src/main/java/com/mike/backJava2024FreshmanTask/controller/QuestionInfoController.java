package com.mike.backJava2024FreshmanTask.controller;

import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.controller.dto.QuestionInfoDTO;
import com.mike.backJava2024FreshmanTask.response.CommonReturnType;
import com.mike.backJava2024FreshmanTask.service.QuestionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问题控制层
 */
@RestController
@RequestMapping("/v1/api/questionInfo")
public class QuestionInfoController {

    @Autowired
    private QuestionInfoService questionInfoService;

    /**
     * 新增或更新问题信息
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/insertOrUpdateQuestionInfo")
    public CommonReturnType insertOrUpdateQuestionInfo(@RequestBody @Validated QuestionInfoDTO input) throws BusinessException {

        return CommonReturnType.create(questionInfoService.insertOrUpdateQuestionInfo(input));
    }

    /**
     * 获取问题信息列表
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/getQuestionInfoList")
    public CommonReturnType getQuestionInfoList(@RequestBody @Validated QuestionInfoDTO input) throws BusinessException {

        return CommonReturnType.create(questionInfoService.getQuestionInfoList(input));
    }

}

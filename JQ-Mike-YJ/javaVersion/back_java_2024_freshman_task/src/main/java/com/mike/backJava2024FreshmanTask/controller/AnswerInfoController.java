package com.mike.backJava2024FreshmanTask.controller;

import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.controller.dto.AnswerInfoDTO;
import com.mike.backJava2024FreshmanTask.response.CommonReturnType;
import com.mike.backJava2024FreshmanTask.service.AnswerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 答案控制层
 */
@RestController
@RequestMapping("/v1/api/answerInfo")
public class AnswerInfoController {

    @Autowired
    private AnswerInfoService answerInfoService;

    /**
     * 新增或更新问题信息
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/insertOrUpdateAnswerInfo")
    public CommonReturnType insertOrUpdateAnswerInfo(@RequestBody @Validated AnswerInfoDTO input) throws BusinessException {

        return CommonReturnType.create(answerInfoService.insertOrUpdateAnswerInfo(input));
    }

    /**
     * 获取问题信息列表
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/getAnswerInfoList")
    public CommonReturnType getAnswerInfoList(@RequestBody @Validated AnswerInfoDTO input) throws BusinessException {

        return CommonReturnType.create(answerInfoService.getAnswerInfoList(input));
    }

}

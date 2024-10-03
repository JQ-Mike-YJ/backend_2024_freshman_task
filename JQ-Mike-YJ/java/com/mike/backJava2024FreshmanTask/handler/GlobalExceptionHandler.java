package com.mike.backJava2024FreshmanTask.handler;

import com.mike.backJava2024FreshmanTask.common.enums.CommonReturnCodeEnums;
import com.mike.backJava2024FreshmanTask.common.error.QuestionAnswerBusinessError;
import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.response.CommonReturnType;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonReturnType doError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception exception) {
        exception.printStackTrace();
        Map<String, Object> responseData = new HashMap<>();
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
        } else if (exception instanceof ServletRequestBindingException) {
            responseData.put("errCode", QuestionAnswerBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", "url绑定路由问题");
        } else if (exception instanceof NoHandlerFoundException) {
            responseData.put("errCode", QuestionAnswerBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", "没有找到对应的访问路径");
        } else {
            responseData.put("errCode", QuestionAnswerBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", QuestionAnswerBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(responseData, CommonReturnCodeEnums.FAIL.getCode(), CommonReturnCodeEnums.FAIL.getStatus());
    }
}


package com.mike.backJava2024FreshmanTask.common.error;

/**
 * 简答系统相关异常
 */
public enum QuestionAnswerBusinessError implements CommonError {

    UNKNOWN_ERROR(1001, "未知错误"),
    PARAMETER_ERROR(1002, "参数不合法"),
    USER_ERROR(1003, "用户相关错误"),
    QUESTION_ERROR(1004, "问题相关错误"),
    ANSWER_ERROR(1005, "答案报名相关错误"),


    ;

    QuestionAnswerBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    private int errCode;
    private String errMsg;


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}

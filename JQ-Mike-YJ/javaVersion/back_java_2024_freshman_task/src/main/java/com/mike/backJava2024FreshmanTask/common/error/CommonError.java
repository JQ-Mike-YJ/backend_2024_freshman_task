package com.mike.backJava2024FreshmanTask.common.error;

public interface CommonError {
    /**
     * 获取错误编码
     *
     * @return int
     */
    public int getErrCode();

    /**
     * 获取错误信息
     *
     * @return String
     */
    public String getErrMsg();

    /**
     * 设置错误信息
     *
     * @param errMsg 错误信息
     * @return CommonError
     */
    public CommonError setErrMsg(String errMsg);
}


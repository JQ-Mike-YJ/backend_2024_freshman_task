package com.mike.backJava2024FreshmanTask.response;

import com.mike.backJava2024FreshmanTask.common.enums.CommonReturnCodeEnums;
import lombok.Data;

/**
 * 通用返回类型
 */
@Data
public class CommonReturnType {

    /**
     * 状态码 CommonReturnCodeEnums
     */
    private Integer code;

    /**
     * 表明对应请求的返回处理结果 "success" 或 "fail"
     */
    private String status;

    /**
     * 若status=success,则data内返回前端需要的json数据
     * 若status=fail，则data内使用通用的错误码格式
     */
    private Object data;

    /**
     * 定义一个通用的创建方法
     *
     * @param result 结果数据
     * @return CommonReturnType
     */
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, CommonReturnCodeEnums.SUCCESS.getCode(), CommonReturnCodeEnums.SUCCESS.getStatus());
    }

    public static CommonReturnType create(Object result, Integer code, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setCode(code);
        type.setStatus(status);
        type.setData(result);
        return type;
    }

}

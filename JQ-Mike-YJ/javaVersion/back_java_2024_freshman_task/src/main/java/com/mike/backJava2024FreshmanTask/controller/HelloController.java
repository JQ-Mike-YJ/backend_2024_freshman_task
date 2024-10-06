package com.mike.backJava2024FreshmanTask.controller;

import cn.hutool.core.lang.Snowflake;
import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.response.CommonReturnType;
import com.mike.backJava2024FreshmanTask.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 欢迎控制层
 */
@RestController
@RequestMapping("/v1/api/hello")
public class HelloController {

    @Autowired
    private Snowflake snowflake;

    @PostMapping("/1")
    public CommonReturnType hello() throws BusinessException {

        long nextId = snowflake.nextId();
        String nextIdStr = snowflake.nextIdStr();

        String encrypt = Base64Util.encrypt("yangJin");
        String decrypt = Base64Util.decrypt(encrypt);

        return CommonReturnType.create(String.join(":", "hello", String.valueOf(nextId), nextIdStr, encrypt, decrypt));
    }

}

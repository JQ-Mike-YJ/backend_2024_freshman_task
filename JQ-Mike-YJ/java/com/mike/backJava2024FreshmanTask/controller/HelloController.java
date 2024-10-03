package com.mike.backJava2024FreshmanTask.controller;

import com.mike.backJava2024FreshmanTask.response.CommonReturnType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 欢迎控制层
 */
@RestController
@RequestMapping("/v1/api/hello")
public class HelloController {

    @PostMapping("/1")
    public CommonReturnType hello() {

        return CommonReturnType.create("hello");
    }

}

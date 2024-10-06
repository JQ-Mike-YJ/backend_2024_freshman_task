package com.mike.backJava2024FreshmanTask.controller;

import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.controller.dto.UserInfoDTO;
import com.mike.backJava2024FreshmanTask.controller.vo.UserInfoReqVO;
import com.mike.backJava2024FreshmanTask.response.CommonReturnType;
import com.mike.backJava2024FreshmanTask.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息控制层
 */
@RestController
@RequestMapping("/v1/api/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户注册
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/register")
    public CommonReturnType register(@RequestBody @Validated UserInfoDTO input) throws BusinessException, Exception {

        return CommonReturnType.create(userInfoService.register(input));
    }

    /**
     * 用户登录
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/login")
    public CommonReturnType login(@RequestBody @Validated UserInfoDTO input) throws BusinessException {

        return CommonReturnType.create(userInfoService.login(input));
    }

    /**
     * 更新用户信息
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/updateUserInfo")
    public CommonReturnType updateUserInfo(@RequestBody @Validated UserInfoDTO input) throws BusinessException {

        return CommonReturnType.create(userInfoService.updateUserInfo(input));
    }

    /**
     * 获取用户信息
     *
     * @param input 参数
     * @return boolean
     */
    @PostMapping("/getUserInfo")
    public CommonReturnType getUserInfo(@RequestBody @Validated UserInfoReqVO input) throws BusinessException {

        return CommonReturnType.create(userInfoService.getUserInfo(input.getUserCode()));
    }

}

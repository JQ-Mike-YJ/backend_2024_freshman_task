package com.mike.backJava2024FreshmanTask.service;

import cn.hutool.core.lang.Snowflake;
import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.common.error.QuestionAnswerBusinessError;
import com.mike.backJava2024FreshmanTask.controller.dto.UserInfoDTO;
import com.mike.backJava2024FreshmanTask.entity.UserInfo;
import com.mike.backJava2024FreshmanTask.repository.UserInfoMapper;
import com.mike.backJava2024FreshmanTask.utils.Base64Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Mike
 * @since 2024-09-06
 */
@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> {

    @Autowired
    private Snowflake snowflake;

    /**
     * 注册
     *
     * @param input 参数
     * @return Boolean
     */
    public Boolean register(UserInfoDTO input) throws Exception {

        // 密码加密处理
        input.setPassword(Base64Util.encrypt(input.getPassword()));
        // 更新用户信息：新增
        input.setCode(snowflake.nextIdStr());
        return this.updateUserInfo(input);
    }

    /**
     * 登录
     *
     * @param input 参数
     * @return Boolean
     */
    public Boolean login(UserInfoDTO input) throws BusinessException {

        // 前置校验：编号为空，返回失败
        if (StringUtils.isBlank(input.getCode())) {
            throw new BusinessException(QuestionAnswerBusinessError.PARAMETER_ERROR, "编号为空");
        }

        // 获取 用户信息
        UserInfoDTO userInfo = this.getUserInfo(input.getCode());
        if (Objects.isNull(userInfo)) {
            // 用户信息 为空，返回 失败
            throw new BusinessException(QuestionAnswerBusinessError.USER_ERROR, "用户不存在");
        }

        // 校验 密码解密后与传入的密码进行比较，校验一致性
        if (StringUtils.equals(Base64Util.decrypt(userInfo.getPassword()), input.getPassword())) {
            throw new BusinessException(QuestionAnswerBusinessError.USER_ERROR, "密码错误");
        }


        // 返回 token
//        JWT.create();

        return null;
    }

    /**
     * 更新用户信息：用户信息存在则更新，否则新增
     *
     * @param input 参数
     * @return Boolean
     */
    public Boolean updateUserInfo(UserInfoDTO input) {

        // 用户编号为空，返回 更新失败
        if (StringUtils.isBlank(input.getCode())) {
            return false;
        }

        // 根据 编号 获取 用户信息
        UserInfoDTO oldUserInfo = getUserInfo(input.getCode());
        int result;
        if (Objects.isNull(oldUserInfo)) {
            // 用户信息不存在 新增
            result = baseMapper.insertSelective(this.dtoToDo(input));
        } else {
            // 用户信息存在 更新
            input.setId(oldUserInfo.getId());
            result = baseMapper.updateByPrimaryKey(this.dtoToDo(input));
        }

        // 返回 更新结果
        return result > 0;
    }

    /**
     * 获取用户信息
     *
     * @param userCode 用户编号
     * @return UserInfoDTO
     */
    public UserInfoDTO getUserInfo(String userCode) {

        UserInfo userInfo = baseMapper.getUserInfoByCode(userCode);
        if (Objects.isNull(userInfo)) {
            return null;
        }
        return this.doToDto(userInfo);
    }

    /**
     * DO 转 DTO
     */
    private UserInfoDTO doToDto(UserInfo userInfo) {
        if (Objects.isNull(userInfo)) {
            return null;
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo, userInfoDTO);
        return userInfoDTO;
    }

    /**
     * DTO 转 DO
     */
    private UserInfo dtoToDo(UserInfoDTO userInfoDTO) {
        if (Objects.isNull(userInfoDTO)) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        userInfo.setUpdateTime(LocalDateTime.now());
        return userInfo;
    }
}

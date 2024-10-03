package com.mike.backJava2024FreshmanTask.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mike.backJava2024FreshmanTask.controller.dto.UserInfoDTO;
import com.mike.backJava2024FreshmanTask.entity.UserInfo;
import com.mike.backJava2024FreshmanTask.repository.UserInfoMapper;
import org.springframework.beans.BeanUtils;
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

    /**
     * 登录
     *
     * @param input 参数
     * @return Boolean
     */
    public Boolean login(UserInfoDTO input) {
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param input 参数
     * @return Boolean
     */
    public Boolean updateUserInfo(UserInfoDTO input) {
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param code 用户编号
     * @return UserInfoDTO
     */
    public UserInfoDTO getUserInfo(String code) {
        return null;
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

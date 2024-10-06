package com.mike.backJava2024FreshmanTask.repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mike.backJava2024FreshmanTask.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 根据 用户编号 获取 用户信息
     *
     * @param userCode 用户编号
     * @return UserInfo
     */
    UserInfo getUserInfoByCode(@Param("userCode") String userCode);
}
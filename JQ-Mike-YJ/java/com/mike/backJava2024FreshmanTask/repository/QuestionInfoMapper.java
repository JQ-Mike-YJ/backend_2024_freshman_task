package com.mike.backJava2024FreshmanTask.repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mike.backJava2024FreshmanTask.controller.dto.QuestionInfoDTO;
import com.mike.backJava2024FreshmanTask.entity.QuestionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionInfoMapper extends BaseMapper<QuestionInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionInfo record);

    int insertSelective(QuestionInfo record);

    QuestionInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionInfo record);

    int updateByPrimaryKey(QuestionInfo record);

    /**
     * 根据 问题ID 获取 问题信息
     *
     * @param questionId 问题ID
     * @return QuestionInfo
     */
    QuestionInfo getQuestionInfoById(@Param("questionId") Long questionId);

    /**
     * 获取问题列表
     *
     * @param questionInfoDTO 参数
     * @return List<QuestionInfo>
     */
    List<QuestionInfo> getQuestionList(QuestionInfoDTO questionInfoDTO);


}
package com.mike.backJava2024FreshmanTask.repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mike.backJava2024FreshmanTask.controller.dto.AnswerInfoDTO;
import com.mike.backJava2024FreshmanTask.entity.AnswerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerInfoMapper extends BaseMapper<AnswerInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(AnswerInfo record);

    int insertSelective(AnswerInfo record);

    AnswerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnswerInfo record);

    int updateByPrimaryKey(AnswerInfo record);

    /**
     * 获取 问题答案列表
     *
     * @param answerInfoDTO 参数
     * @return List<AnswerInfo>
     */
    List<AnswerInfo> getAnswerList(AnswerInfoDTO answerInfoDTO);
}
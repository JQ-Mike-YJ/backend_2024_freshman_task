package com.mike.backJava2024FreshmanTask.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.common.error.QuestionAnswerBusinessError;
import com.mike.backJava2024FreshmanTask.controller.dto.QuestionInfoDTO;
import com.mike.backJava2024FreshmanTask.entity.QuestionInfo;
import com.mike.backJava2024FreshmanTask.repository.QuestionInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 酒店表 服务实现类
 * </p>
 *
 * @author Mike
 * @since 2024-09-06
 */
@Service
public class QuestionInfoService extends ServiceImpl<QuestionInfoMapper, QuestionInfo> {

    /**
     * 新增或更新问题
     *
     * @param questionInfoDTO 参数
     * @return boolean
     */
    public boolean insertOrUpdateQuestionInfo(QuestionInfoDTO questionInfoDTO) throws BusinessException {

        // 实体初始化
        QuestionInfo entity = this.dtoToDo(questionInfoDTO);
        if (Objects.isNull(entity)) {
            throw new BusinessException(QuestionAnswerBusinessError.UNKNOWN_ERROR, "实体初始化失败");
        }
        // 查询问题是否存在
        List<QuestionInfoDTO> questionList = getQuestionInfoList(questionInfoDTO);
        int result;
        if (CollectionUtils.isEmpty(questionList)) {
            // 问题不存在，新增
            result = baseMapper.insertSelective(entity);
        } else {
            // 存在，更新
            QuestionInfoDTO oldQuestionInfo = questionList.get(0);
            entity.setId(oldQuestionInfo.getId());
            result = baseMapper.updateByPrimaryKeySelective(entity);
        }

        return result > 0;
    }

    /**
     * 查询问题列表
     *
     * @param questionInfoDTO 参数
     * @return List<QuestionInfoDTO>
     */
    public List<QuestionInfoDTO> getQuestionInfoList(QuestionInfoDTO questionInfoDTO) {

        List<QuestionInfo> questionInfoList = baseMapper.getQuestionList(questionInfoDTO);
        if (CollectionUtils.isEmpty(questionInfoList)) {
            return new ArrayList<>();
        }
        return questionInfoList.stream().map(this::doToDto).collect(Collectors.toList());
    }

    /**
     * DO 转 DTO
     */
    private QuestionInfoDTO doToDto(QuestionInfo questionInfo) {
        if (Objects.isNull(questionInfo)) {
            return null;
        }
        QuestionInfoDTO questionInfoDTO = new QuestionInfoDTO();
        BeanUtils.copyProperties(questionInfo, questionInfoDTO);
        return questionInfoDTO;
    }

    /**
     * DTO 转 DO
     */
    private QuestionInfo dtoToDo(QuestionInfoDTO questionInfoDTO) {
        if (Objects.isNull(questionInfoDTO)) {
            return null;
        }
        QuestionInfo questionInfo = new QuestionInfo();
        BeanUtils.copyProperties(questionInfoDTO, questionInfo);
        questionInfo.setUpdateTime(LocalDateTime.now());
        return questionInfo;
    }

}

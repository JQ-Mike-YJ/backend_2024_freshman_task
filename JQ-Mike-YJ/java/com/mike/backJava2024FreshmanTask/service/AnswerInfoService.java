package com.mike.backJava2024FreshmanTask.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.common.error.QuestionAnswerBusinessError;
import com.mike.backJava2024FreshmanTask.controller.dto.AnswerInfoDTO;
import com.mike.backJava2024FreshmanTask.entity.AnswerInfo;
import com.mike.backJava2024FreshmanTask.entity.QuestionInfo;
import com.mike.backJava2024FreshmanTask.repository.AnswerInfoMapper;
import com.mike.backJava2024FreshmanTask.repository.QuestionInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 答案表 服务实现类
 * </p>
 *
 * @author Mike
 * @since 2024-09-06
 */
@Service
public class AnswerInfoService extends ServiceImpl<AnswerInfoMapper, AnswerInfo> {

    @Autowired
    private QuestionInfoMapper questionInfoMapper;

    /**
     * 新增或更新答案
     *
     * @param answerInfoDTO 参数
     * @return boolean
     */
    public boolean insertOrUpdateAnswerInfo(AnswerInfoDTO answerInfoDTO) throws BusinessException {

        // 问题ID 为空，直接返回 失败
        if (Objects.isNull(answerInfoDTO.getQuestionId())) {
            throw new BusinessException(QuestionAnswerBusinessError.PARAMETER_ERROR, "问题ID为空");
        }

        // 用户信息（答案创建人）不存在，直接返回 失败
        if (StringUtils.isBlank(answerInfoDTO.getCreatorCode())) {
            throw new BusinessException(QuestionAnswerBusinessError.PARAMETER_ERROR, "创建人code为空");
        }

        // 根据 问题ID 获取问题信息
        QuestionInfo questionInfo = questionInfoMapper.getQuestionInfoById(answerInfoDTO.getQuestionId());
        // 问题信息不存在，返回失败
        if (Objects.isNull(questionInfo)) {
            throw new BusinessException(QuestionAnswerBusinessError.QUESTION_ERROR, "问题不存在");
        }

        // 实体初始化
        AnswerInfo entity = this.dtoToDo(answerInfoDTO);
        if (Objects.isNull(entity)) {
            throw new BusinessException(QuestionAnswerBusinessError.UNKNOWN_ERROR, "实体初始化失败");
        }

        // 查询问题是否存在：一个问题一个用户只有一个答案
        List<AnswerInfoDTO> answerList = getAnswerInfoList(answerInfoDTO);
        int result;
        if (CollectionUtils.isEmpty(answerList)) {
            // 问题不存在，新增
            result = baseMapper.insertSelective(entity);
        } else {
            // 存在，更新
            AnswerInfoDTO oldAnswerInfo = answerList.get(0);
            entity.setId(oldAnswerInfo.getId());
            result = baseMapper.updateByPrimaryKeySelective(entity);
        }

        return result > 0;
    }

    /**
     * 查询问题答案列表
     *
     * @param answerInfoDTO 参数
     * @return List<AnswerInfoDTO>
     */
    public List<AnswerInfoDTO> getAnswerInfoList(AnswerInfoDTO answerInfoDTO) throws BusinessException {

        // 问题ID 为空，直接返回空列表
        if (Objects.isNull(answerInfoDTO.getQuestionId())) {
            throw new BusinessException(QuestionAnswerBusinessError.PARAMETER_ERROR, "问题ID为空");
        }

        // 查询问题答案列表
        List<AnswerInfo> answerInfoList = baseMapper.getAnswerList(answerInfoDTO);
        if (CollectionUtils.isEmpty(answerInfoList)) {
            return new ArrayList<>();
        }
        return answerInfoList.stream().map(this::doToDto).collect(Collectors.toList());
    }

    /**
     * DO 转 DTO
     */
    private AnswerInfoDTO doToDto(AnswerInfo answerInfo) {
        if (Objects.isNull(answerInfo)) {
            return null;
        }
        AnswerInfoDTO answerInfoDTO = new AnswerInfoDTO();
        BeanUtils.copyProperties(answerInfo, answerInfoDTO);
        return answerInfoDTO;
    }

    /**
     * DTO 转 DO
     */
    private AnswerInfo dtoToDo(AnswerInfoDTO answerInfoDTO) {
        if (Objects.isNull(answerInfoDTO)) {
            return null;
        }
        AnswerInfo answerInfo = new AnswerInfo();
        BeanUtils.copyProperties(answerInfoDTO, answerInfo);
        answerInfo.setUpdateTime(LocalDateTime.now());
        return answerInfo;
    }

}

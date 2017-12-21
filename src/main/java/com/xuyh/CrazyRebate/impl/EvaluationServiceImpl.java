package com.xuyh.CrazyRebate.impl;

import com.xuyh.CrazyRebate.mapper.EvaluationMapper;
import com.xuyh.CrazyRebate.model.Evaluation;
import com.xuyh.CrazyRebate.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public void addEvaluation(Evaluation evaluation) {
        evaluationMapper.add(evaluation);
    }

    @Override
    public List<Evaluation> getEvaluation(int shareId) {
        return evaluationMapper.getEvaluationList(shareId);
    }
}

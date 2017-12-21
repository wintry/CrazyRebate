package com.xuyh.CrazyRebate.service;

import com.xuyh.CrazyRebate.model.Evaluation;

import java.util.List;

public interface EvaluationService {

    public  void addEvaluation(Evaluation evaluation);

    public List<Evaluation> getEvaluation(int shareId);
}

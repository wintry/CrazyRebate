package com.xuyh.CrazyRebate.mapper;

import com.xuyh.CrazyRebate.model.Evaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvaluationMapper {




    @Insert("insert into evaluation(share_id,score ,content,img,user_id) values(#{shareId}, #{score}, #{content},#{img},#{userId})")
    public void add(Evaluation evaluation);

    @Select("SELECT * FROM evaluation where share_id =#{shareId}")
    public List<Evaluation> getEvaluationList(Integer shareId);
}

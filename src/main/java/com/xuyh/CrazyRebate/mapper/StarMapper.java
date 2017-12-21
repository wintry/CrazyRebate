package com.xuyh.CrazyRebate.mapper;

import com.xuyh.CrazyRebate.model.Star;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StarMapper {

    @Insert("insert into star(user_id, share_id, create_time) values(#{userId}, #{shareId}, #{createTime})")
    public int add(Star star);
    @Delete("DELETE from star where id = #{id} ")
    public int delete(Integer id);
    @Select("SELECT * FROM star where user_id = #{userId}")
    public List<Star> getStarList(Integer userId);


}

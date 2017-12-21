package com.xuyh.CrazyRebate.mapper;

import com.xuyh.CrazyRebate.model.Share;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ShareMapper {

    @Insert("insert into share(user_id, title, content,url,img,price,create_time) values(#{userId}, #{title}, #{content},#{url},#{img},#{price},#{createTime})")
    public int add(Share share);
    @Select("SELECT * FROM share WHERE id = #{id}")
    Share getShareById(int id);
}

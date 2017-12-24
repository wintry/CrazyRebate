package com.xuyh.CrazyRebate.mapper;

import com.xuyh.CrazyRebate.model.Share;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShareMapper {

    @Insert("insert into share(user_id, title, content,url,img,price,create_time) values(#{userId}, #{title}, #{content},#{url},#{img},#{price},#{createTime})")
    public int add(Share share);
    @Select("SELECT * FROM share WHERE id = #{id}")
    Share getShareById(int id);
    @Update("UPDATE share SET title = #{share.title},content = #{share.content},url=#{share.url},img=#{share.img},price=#{share.price} WHERE id = #{share.id}")
    public int updateShare(@Param("share") Share share);
    @Delete("DELETE from share where id = #{id} ")
    public int delShare(Integer id);
    @Select("SELECT * FROM share WHERE title like #{s}")
    public List<Share> seShare(String s);
}

package com.xuyh.CrazyRebate.mapper;

import com.xuyh.CrazyRebate.model.UserLook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserLookMapper {


    @Select("SELECT * FROM user_look WHERE user_id = #{userId} and share_id=#{shareId}")
    UserLook getUserLook(@Param("userId") Integer userId, @Param("shareId") Integer shareId);

    @Insert("insert into user_look(user_id, share_id,create_time) values(#{userId}, #{shareId}, #{createTime})")
    int add(UserLook userLook);


}

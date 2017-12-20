package com.xuyh.CrazyRebate.mapper;

import com.xuyh.CrazyRebate.model.User;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);

    @Select("SELECT * FROM user WHERE userName = #{userName}")
    User getUserByUserName(String username);

    @Select("SELECT * FROM user")
    public List<User> getUserList();

    @Insert("insert into user(userName, pwd, phone) values(#{userName}, #{pwd}, #{phone})")
    public int add(User user);

    @Update("UPDATE user SET username = #{user.username} , age = #{user.age} WHERE id = #{id}")
    public int update(@Param("id") Integer id, @Param("user") User user);

    @Delete("DELETE from user where id = #{id} ")
    public int delete(Integer id);



    @Update("UPDATE user SET token = #{user.token} WHERE id = #{user.id}")
    public int updateToken(@Param("user") User user);
    @Update("UPDATE user SET img = #{user.img} WHERE id = #{user.id}")
    public int updateImg(@Param("user") User user);
    @Select("SELECT * FROM user WHERE token = #{token}")
    public User getUserIdByToken(String token);
}

package com.xuyh.CrazyRebate.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.xuyh.CrazyRebate.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    User getUserById(Integer id);

    public User getUserByUserName(String userName);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);


    public User updateToken(User user);

    public User getUserIdByToken(String token);

    public User OAuth(HttpServletRequest request);

    public int updateImg(User user);
}

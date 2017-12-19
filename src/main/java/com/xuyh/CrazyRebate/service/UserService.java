package com.xuyh.CrazyRebate.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.xuyh.CrazyRebate.model.User;

public interface UserService {

    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);
}

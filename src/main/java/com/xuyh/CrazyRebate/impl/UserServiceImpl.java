package com.xuyh.CrazyRebate.impl;

import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.mapper.UserMapper;
import com.xuyh.CrazyRebate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userMapper.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}

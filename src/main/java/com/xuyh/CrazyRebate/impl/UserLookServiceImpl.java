package com.xuyh.CrazyRebate.impl;

import com.xuyh.CrazyRebate.mapper.UserLookMapper;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.model.UserLook;
import com.xuyh.CrazyRebate.service.UserLookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserLookServiceImpl implements UserLookService {

    @Autowired
    private UserLookMapper userLookMapper;

    @Override
    public UserLook getUserLook(int userId, int shareId) {
        return userLookMapper.getUserLook(userId,shareId);
    }

    @Override
    public int add(int userId, int shareId) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        UserLook userLook = new UserLook();
        userLook.setUserId(userId);
        userLook.setShareId(shareId);
        userLook.setCreateTime(dateFormat.format( now ));
        return userLookMapper.add(userLook);
    }

    @Override
    public List<UserLook> getList(int userId) {
        return userLookMapper.getList(userId);
    }
}

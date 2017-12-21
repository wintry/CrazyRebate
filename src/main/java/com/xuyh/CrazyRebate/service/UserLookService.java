package com.xuyh.CrazyRebate.service;

import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.model.UserLook;

import java.util.List;

public interface UserLookService {

    public UserLook getUserLook(int userId,int shareId);

    public int add(int userId,int shareId);

    public List<UserLook> getList(int userId);
}

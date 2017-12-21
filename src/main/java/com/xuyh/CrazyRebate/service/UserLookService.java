package com.xuyh.CrazyRebate.service;

import com.xuyh.CrazyRebate.model.UserLook;

public interface UserLookService {

    public UserLook getUserLook(int userId,int shareId);

    public int add(int userId,int shareId);
}

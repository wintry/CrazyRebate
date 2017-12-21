package com.xuyh.CrazyRebate.impl;

import com.xuyh.CrazyRebate.mapper.StarMapper;
import com.xuyh.CrazyRebate.model.Star;
import com.xuyh.CrazyRebate.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarServiceImpl implements StarService{

    @Autowired
    private StarMapper starMapper;

    @Override
    public void addStar(Star star) {
        starMapper.add(star);
    }


    @Override
    public void delStar(int id) {
        starMapper.delete(id);
    }

    @Override
    public List<Star> getStarList(int userId) {
        return starMapper.getStarList(userId);
    }
}

package com.xuyh.CrazyRebate.service;

import com.xuyh.CrazyRebate.model.Star;

import java.util.List;

public interface StarService {

    public  void addStar(Star star);

    public  void delStar(int id);

    public List<Star> getStarList(int userId);

}

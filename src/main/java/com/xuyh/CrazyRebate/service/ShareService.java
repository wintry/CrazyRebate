package com.xuyh.CrazyRebate.service;

import com.xuyh.CrazyRebate.model.Share;

import java.util.List;

public interface ShareService {

    public int addShare(Share share);

    public  Share getShareById(int shareId);

    public  int updateShare(Share share);

    public  int delShare(int id);

    public List<Share> seShare(String s);

}

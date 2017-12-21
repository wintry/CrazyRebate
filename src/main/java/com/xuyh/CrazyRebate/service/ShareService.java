package com.xuyh.CrazyRebate.service;

import com.xuyh.CrazyRebate.model.Share;

public interface ShareService {

    public int addShare(Share share);

    public  Share getShareById(int shareId);

}

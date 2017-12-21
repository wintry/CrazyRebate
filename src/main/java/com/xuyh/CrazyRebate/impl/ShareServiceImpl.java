package com.xuyh.CrazyRebate.impl;

import com.xuyh.CrazyRebate.mapper.ShareMapper;
import com.xuyh.CrazyRebate.model.Share;
import com.xuyh.CrazyRebate.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareMapper shareMapper;

    @Override
    public int addShare(Share share) {
        return shareMapper.add(share);
    }
    @Override
    public  Share getShareById(int shareId){
        return shareMapper.getShareById(shareId);
    }
}

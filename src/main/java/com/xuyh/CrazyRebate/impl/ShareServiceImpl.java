package com.xuyh.CrazyRebate.impl;

import com.xuyh.CrazyRebate.mapper.ShareMapper;
import com.xuyh.CrazyRebate.model.Share;
import com.xuyh.CrazyRebate.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int updateShare(Share share) {
        return shareMapper.updateShare(share);
    }

    @Override
    public int delShare(int id) {
        return shareMapper.delShare(id);
    }


    @Override
    public List<Share> seShare(String s) {
        return shareMapper.seShare(s);
    }
}

package com.xuyh.CrazyRebate.controller;

import com.xuyh.CrazyRebate.model.*;
import com.xuyh.CrazyRebate.service.ShareService;
import com.xuyh.CrazyRebate.service.UserLookService;
import com.xuyh.CrazyRebate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserLookController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLookService userLookService;
    @Autowired
    private ShareService shareService;

    @RequestMapping(value = "getUrls/", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserLook ( HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }


        List<Share> shareList =new ArrayList<Share>();
        List<UserLook> userLookList = userLookService.getList(user.getId());
        for(UserLook userLook :userLookList){
            Share share = shareService.getShareById(userLook.getShareId());
            shareList.add(share);
        }

        r.setStatus("003");
        r.setResult(shareList);
        return ResponseEntity.ok(r);
    }

}

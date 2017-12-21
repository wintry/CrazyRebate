package com.xuyh.CrazyRebate.controller;

import com.xuyh.CrazyRebate.model.JsonResult;
import com.xuyh.CrazyRebate.model.Share;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.model.UserLook;
import com.xuyh.CrazyRebate.service.ShareService;
import com.xuyh.CrazyRebate.service.UserLookService;
import com.xuyh.CrazyRebate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "share")
public class ShareController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShareService shareService;
    @Autowired
    private UserLookService userLookService;


    @RequestMapping(value = "addShare", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> addShare(@RequestBody Share share,HttpServletRequest request) {

        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
            }


            Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        share.setCreateTime( dateFormat.format( now ));
        share.setUserId(user.getId());
        shareService.addShare(share);


        r.setStatus("001");
        r.setResult("succeed");




        return ResponseEntity.ok(r);
    }


    /**
     * 获得推广信息
     * @param shareId
     * @return
     */
    @RequestMapping(value = "getShare/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getShareById (@PathVariable(value = "id") int shareId,HttpServletRequest request) {
        JsonResult r = new JsonResult();
        Share share=shareService.getShareById(shareId);


        User user= userService.OAuth(request);
        if(user!=null){
            UserLook userLook = userLookService.getUserLook(user.getId(),shareId);
            if (userLook==null){
                share.setUrl(null);

            }
        }


        r.setStatus("001");
        r.setResult(share);
        return  ResponseEntity.ok(r);


    }

    /**
     * 获取商品购买链接
     * @param shareId
     * @param request
     * @return
     */
    @RequestMapping(value = "getUrl/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getShareUrl (@PathVariable(value = "id") int shareId ,HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }

        Share share = shareService.getShareById(shareId);


        UserLook userLook = userLookService.getUserLook(user.getId(),shareId);
        if (userLook==null){
            userLookService.add(user.getId(),shareId);

        }

        r.setStatus("001");
        r.setResult(share.getUrl());


         return  ResponseEntity.ok(r);
    }


    /**
     * 修改推广商品信息
     * @param share
     * @param request
     * @return
     */
    @RequestMapping(value = "updateShare", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> eidtShare(@RequestBody Share share,HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }

        Share share1 = shareService.getShareById(share.getId());

        if(share1.getUserId()!=user.getId()){
            r.setStatus("002");
            r.setResult("not your share");
            return ResponseEntity.ok(r);
        }
        share.setUserId(user.getId());

        shareService.updateShare(share);
        r.setStatus("001");
        r.setResult("succeed");
        return ResponseEntity.ok(r);
    }


    @RequestMapping(value = "delShare/{id}", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> delShare(@PathVariable(value = "id") int shareId,HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }
        Share share = shareService.getShareById(shareId);

        if(share.getUserId()!=user.getId()){
            r.setStatus("002");
            r.setResult("not your share");
            return ResponseEntity.ok(r);
        }

        shareService.delShare(shareId);

        r.setStatus("001");
        r.setResult("succeed");
        return ResponseEntity.ok(r);
    }



}

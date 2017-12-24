package com.xuyh.CrazyRebate.controller;

import com.xuyh.CrazyRebate.model.JsonResult;
import com.xuyh.CrazyRebate.model.Share;
import com.xuyh.CrazyRebate.model.Star;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.service.ShareService;
import com.xuyh.CrazyRebate.service.StarService;
import com.xuyh.CrazyRebate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "star")
@CrossOrigin
public class StarController {
    @Autowired
    private StarService starService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShareService shareService;


    @RequestMapping(value = "addStar/{shareId}", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> addStar(@PathVariable(value = "shareId") int shareId, HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }

        Star star = new Star();
        star.setUserId(user.getId());
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        star.setCreateTime( dateFormat.format( now ));
        star.setShareId(shareId);

        starService.addStar(star);
        r.setStatus("001");
        r.setResult("succeed");
        return ResponseEntity.ok(r);

    }


    @RequestMapping(value = "delStar/{starId}", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> delStar(@PathVariable(value = "starId") int starId, HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }

        starService.delStar(starId);
        r.setStatus("001");
        r.setResult("succeed");
        return ResponseEntity.ok(r);


    }


    @RequestMapping(value = "getStar", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getStar( HttpServletRequest request) {

        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }

        List<Star> stars = starService.getStarList(user.getId());
        List<Share> shares = new ArrayList<Share>();
        for (Star star : stars){
            Share share = shareService.getShareById(star.getShareId());
            shares.add(share);
        }
        r.setStatus("001");
        r.setResult(shares);
        return ResponseEntity.ok(r);




    }





}

package com.xuyh.CrazyRebate.controller;

import com.xuyh.CrazyRebate.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.xuyh.CrazyRebate.service.UserService;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.model.JsonResult;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getuser/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUser (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> register (@RequestBody User user){

        JsonResult r = new JsonResult();
        if(userService.getUserByUserName(user.getUserName())!=null){
            r.setStatus("0");
            r.setResult("username already exists");
            return ResponseEntity.ok(r);
        }

        user.setPwd(MD5.MD5(user.getPwd()));
        if(userService.add(user)==1){
            r.setResult("succeed");

            r.setStatus("1");
        }


        return ResponseEntity.ok(r);
    }


    }

package com.xuyh.CrazyRebate.controller;

import com.google.gson.Gson;
import com.xuyh.CrazyRebate.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.xuyh.CrazyRebate.service.UserService;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.model.JsonResult;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getuser/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUser(@PathVariable(value = "id") Integer id) {
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
    public ResponseEntity<JsonResult> register(@RequestBody User user) {

        JsonResult r = new JsonResult();
        if (userService.getUserByUserName(user.getUserName()) != null) {
            r.setStatus("0");
            r.setResult("username already exists");
            return ResponseEntity.ok(r);
        }

        user.setPwd(MD5.MD5(user.getPwd()));
        if (userService.add(user) == 1) {
            r.setResult("succeed");
            r.setStatus("1");
        }


        return ResponseEntity.ok(r);
    }



    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> login(@RequestBody User user) {
        JsonResult r = new JsonResult();




        User user1 =userService.getUserByUserName(user.getUserName());
        if (user1.getPwd().equals(MD5.MD5(user.getPwd()))) {

            String string = UUID.randomUUID().toString();
            user1.setToken(string);
            user1=userService.updateToken(user1);
            r.setResult(user1.getToken());
            r.setStatus("1");

        }
        else {
            r.setStatus("0");
            r.setResult("username or pwd is wrong ");
        }
        return ResponseEntity.ok(r);

    }


    /**
     * 更新头像
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "updateImg/{imgUrl}", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateImg(@PathVariable(value = "imgUrl") String imgUrl, HttpServletRequest request) {
        JsonResult r = new JsonResult();


        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);

        }
        user.setImg(imgUrl);
        userService.updateImg(user);

        r.setStatus("1");
        r.setResult("succeed");
        return ResponseEntity.ok(r);
    }



}

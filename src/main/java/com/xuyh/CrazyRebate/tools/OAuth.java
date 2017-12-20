package com.xuyh.CrazyRebate.tools;

import com.xuyh.CrazyRebate.model.JsonResult;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class OAuth {

    @Autowired
    UserService userService;

    public User OAuth(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = userService.getUserIdByToken(token);
        if(user!=null){
            return user;
        }
        else {
            return  null;
        }
    }
}

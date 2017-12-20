package com.xuyh.CrazyRebate.controller;

import com.xuyh.CrazyRebate.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/img")
@CrossOrigin
public class imgController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/upload")
    @ResponseBody
    public Map imageUpload(String Imgype, String value, HttpServletRequest request) {


        Map map =imageService.uploadImage(value, request.getSession().getServletContext());
        return map;
    }


}

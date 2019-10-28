package com.mint.demo.controller;

import com.mint.demo.entity.UserEntity;
import com.mint.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/21
 * Time: 15:44
 */

@Controller
@RequestMapping("/index")
@ResponseBody
public class BaseController {


    @Autowired
    BaseService baseService = new BaseService();
    @RequestMapping("/")
    public UserEntity demo(){

        //return "hello,lmm";



        return baseService.selectById(1);
    }

}

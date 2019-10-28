package com.mint.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/23
 * Time: 15:08
 */
@ResponseBody
@Controller
@RequestMapping("/")
public class front {

     @RequestMapping("/front")
     public String frontTest(){

         //return "/bootstrap.html";
         return "/show.html";
     }


}

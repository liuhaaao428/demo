package com.mint.demo.controller;

import com.mint.demo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/24
 * Time: 14:05
 */

@Controller
@ResponseBody
@RequestMapping("/show")
@CrossOrigin(origins = "*")
public class ShowController {

    @Autowired
    ShowService showService;


    @RequestMapping("/")
    @CrossOrigin(origins = "*")
    public Map showAll(@RequestParam("curPage") int curPage){


        return showService.showUser(curPage);
    }




}

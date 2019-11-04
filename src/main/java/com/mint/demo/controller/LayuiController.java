package com.mint.demo.controller;

import com.mint.demo.service.LayuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/31
 * Time: 14:43
 */
@Controller
@ResponseBody
@RequestMapping("/layui")
@CrossOrigin(origins = "*")
public class LayuiController {

    @Autowired
    LayuiService layuiService;

    @RequestMapping("/")
    @CrossOrigin(origins = "*")
    public String LayuiShow(@RequestParam("page") int curPage,@RequestParam("limit") int limit){

        return layuiService.layuiShowUser(curPage,limit);
    }

    @RequestMapping("/imgupload")
    @CrossOrigin(origins = "*")
    public String LayuiImgUpload(MultipartFile file){

        return layuiService.layuiImgUpload(file);
    }


}

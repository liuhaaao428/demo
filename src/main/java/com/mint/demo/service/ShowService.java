package com.mint.demo.service;

import com.google.gson.Gson;
import com.mint.demo.utils.PageInfo;
import com.mint.demo.entity.UserEntity;
import com.mint.demo.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/24
 * Time: 14:06
 */
@Service
public class ShowService {

    @Autowired
    UserEntityMapper userEntityMapper;
    @Autowired
    PageInfo pageInfo;


    public Map showUser(int curPage){

        List <UserEntity> showList ;
        Map<String,String> page = new HashMap<>();
        Gson showListGson = new Gson();
        showList = userEntityMapper.showPartment((curPage-1)*10,10);
        String showListJson = showListGson.toJson(showList);
        pageInfo.setCurPage(curPage);
        pageInfo.setPageSize(10);
        pageInfo.setTotalPage();
        pageInfo.setTotalRows();
        page.put("PageInfo",pageInfo.toString());
        page.put("ShowListJson",showListJson);
        return page;
    }
}

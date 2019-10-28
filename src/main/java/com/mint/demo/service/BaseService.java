package com.mint.demo.service;

import com.mint.demo.entity.UserEntity;
import com.mint.demo.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/22
 * Time: 9:08
 */
@Service
public class BaseService {

    @Autowired
    private UserEntityMapper userEntityMapper;
    UserEntity userEntity=null;
    public UserEntity selectById(int id){

        userEntity = userEntityMapper.selectById(id);
        return userEntity;
    }
}

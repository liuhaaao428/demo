package com.mint.demo.mapper;

import com.mint.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserEntityMapper {
    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    int selectCount();


    UserEntity selectById(int id);

    List showPartment(@Param("curPage") int curPage,@Param("pageSize") int pageSize);


    List showAll(@Param("curPage") int curPage,@Param("pageSize") int pageSize);
}
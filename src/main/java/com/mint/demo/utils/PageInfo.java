package com.mint.demo.utils;

import com.mint.demo.mapper.UserEntityMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/25
 * Time: 14:27
 */
@Component
@Resource
public class PageInfo {

    @Autowired
    UserEntityMapper userEntityMapper;

    private int curPage;

    //当前多少页

    private int totalPage;
    //一共有多少页

    private int pageSize;
    //一页有多少数据

    private boolean hasPriviousPage;
    //是否有上一页

    private boolean hasNextPage;
    //是否有下一页

    private int totalRows;
    //一共有多少行


    public void setPageSize(int pageSize){

        this.pageSize = pageSize;
    }

    public int getPageSize(){

        return this.pageSize;
    }


    public void setCurPage(int curPage){

        this.curPage = curPage;
    }


    public int getCurPage(){

        return this.curPage;
    }


    public void setTotalPage(){

        if(totalRows%this.pageSize==0){
            this.totalPage=this.totalRows/this.pageSize;
        }
        else {
            this.totalPage=this.totalRows/this.pageSize+1;
        }

    }

    public int getTotalPage(){

        if(totalRows%this.pageSize==0){
            totalPage=this.totalRows/this.pageSize;
        }
        else {
            totalPage=this.totalRows/this.pageSize+1;
        }
        return totalPage;

    }



    public void setTotalRows(){

        this.totalRows = userEntityMapper.selectCount();
    }



    public int getTotalRows(){

        return this.totalRows;
    }


    public boolean getHasPriviousPage(){

        if(curPage==1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean getHasNextPage(){

        if(curPage==totalPage){
            return false;
        }
        else {
            return true;
        }

    }

    public String toString(){
        return "{\"curPage\":"+this.getCurPage()+",\"totalPage\":"+this.getTotalPage()+",\"pageSize\":"+this.getPageSize()+",\"hasPriviousPage\":"+"\""+this.getHasPriviousPage()+"\""+",\"hasNextPage\""+":"+"\""+this.getHasNextPage()+"\""+",\"totalRows\":"+this.getTotalRows()+"}";
    }
}

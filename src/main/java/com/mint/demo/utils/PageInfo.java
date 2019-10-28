package com.mint.demo.utils;

import com.mint.demo.mapper.UserEntityMapper;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/25
 * Time: 14:27
 */
@Data
@Component
public class PageInfo {

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

    public int getTotalPage(){

        if(totalRows%pageSize==0){
            totalPage=totalRows/pageSize;
        }
        else {
            totalPage=totalRows/pageSize+1;
        }
        return totalPage;

    }

    public boolean getHasPriviousPage(){

        if(curPage==0){
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
        return "{'curPage':"+curPage+",'totalPage':"+totalPage+",'pageSize':"+pageSize+",'hasPriviousPage':"+hasPriviousPage+",'hasNextPage':"+hasNextPage+"}";
    }
}

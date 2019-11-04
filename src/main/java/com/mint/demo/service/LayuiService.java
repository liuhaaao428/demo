package com.mint.demo.service;

import com.google.gson.Gson;
import com.mint.demo.entity.UserEntity;
import com.mint.demo.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2019/10/31
 * Time: 14:48
 */
@Service
public class LayuiService {

    @Resource
    UserEntityMapper userEntityMapper;


    @Value(value = "${image.path}")
    private String imagePath;

    @Value(value = "${image.host}")
    private String imageHost;



    public String layuiShowUser(int curPage, int pageSize){

        List<UserEntity> userList ;

        userList = userEntityMapper.showAll((curPage-1)*10,pageSize);
        Gson showAllGson = new Gson();
        String showAllJson = showAllGson.toJson(userList);
        return "{\"code\":0,\"msg\":\"\",\"count\":"+userEntityMapper.selectCount()+",\"data\":"+showAllJson+"}";
    }


    public String layuiImgUpload(MultipartFile file){

        if(file.isEmpty()){

            return "{\"code\":"+(-1)+",\"msg\":\"\",\"data\":{\"\"}";
        }
        StringBuffer fileName = new StringBuffer();
        fileName.append(UUID.randomUUID().toString().replace("-",""));
        String type = file.getContentType();
        if("image/png".equals(type)){
            fileName.append(".png");
        }
        else if("image/jpeg".equals(type)){
            fileName.append(".jpeg");
        }
        else if("image/gif".equals(type)){
            fileName.append(".gif");
        }
        else {
            return "{\"code\":"+(-1);
        }
        /*if(file.getSize()>1021000L){
            return "{\"code\":"+(-1);
        }*/
        try {
            file.transferTo(new File(imagePath,fileName.toString()));
            return "{\"code\":"+0+",\"msg\":"+"\""+fileName+"\""+",\"data\":{\n\"src\":\"http://localhost:8080/img/"+fileName+"\"\n}\n}";
        }catch (IOException e){
            e.printStackTrace();
            return "{\"code\":"+(-1);
        }



    }


}

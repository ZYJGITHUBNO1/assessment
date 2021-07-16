package com.itcast.controller;

import com.alibaba.fastjson.JSONObject;
import com.itcast.pojo.Image;
import com.itcast.pojo.PictureData;
import com.itcast.service.impl.YbServiceImpl;
import com.itcast.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("yb")
public class YbController {

    @Autowired
    private YbServiceImpl ybService;

    /**
     * 获取 token
     *
     * @return
     */
    @GetMapping("token")
    public ResponseEntity<JSONObject> getToken(){
        JSONObject token = ybService.getToken();
        return ResponseEntity.ok(token);
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping("upload")
    public ResponseEntity<Image> uploadFile(@RequestParam(value = "file") MultipartFile file){

        Image image = ybService.uploadFile(file);

        if(image != null){
            return ResponseEntity.ok(image);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 解析图片获取数据
     * @param map
     * @return
     */
    @PostMapping("getData")
    public ResponseEntity<JSONObject> getData(@RequestBody Map<String,String> map){

        String token = map.get("token");

        String imagepath = map.get("imagepath");
        String imageid = map.get("imageid");

        JSONObject result = ybService.getData(token,imageid,imagepath);

        if(result != null){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}

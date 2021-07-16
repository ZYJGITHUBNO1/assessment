package com.itcast.service;

import com.alibaba.fastjson.JSONObject;
import com.itcast.pojo.Image;
import com.itcast.pojo.PictureData;
import com.itcast.vo.ApiResult;
import org.springframework.web.multipart.MultipartFile;

public interface YbService {

    /**
     * 获取 token
     * @return
     */
    JSONObject getToken();

    /**
     * 上传图片
     * @param file
     * @return
     */
    Image uploadFile(MultipartFile file);

    /**
     * 解析图片获取数据
     * @param imageid
     * @param imagepath
     * @return
     */
    JSONObject getData(String token,String imageid, String imagepath);
}

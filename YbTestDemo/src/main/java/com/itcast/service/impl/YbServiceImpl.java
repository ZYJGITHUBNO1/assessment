package com.itcast.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itcast.pojo.Image;
import com.itcast.pojo.PictureData;
import com.itcast.pojo.Yb;
import com.itcast.service.YbService;
import com.itcast.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class YbServiceImpl implements YbService {

    @Autowired
    private ImageServiceImpl imageService;

    @Autowired
    private PictureDataServiceImpl pictureDataService;

    @Autowired
    private Yb yb;

    @Value("${sb.url}")
    private String sbUrl;

    /**
     * 获取 token
     * @return
     */
    @Override
    public JSONObject getToken() {

        String url = yb.getUrl();
        String accessKey = yb.getAccessKey();
        String accessSecret = yb.getAccessSecret();

        Map<String,String> map = new HashMap<>();
        map.put("accessKey",accessKey);
        map.put("accessSecret",accessSecret);

        String token = RequestUtil.yuebaoGet(url, map);

        JSONObject json = JSONObject.parseObject(token);

        return json;
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @Override
    public Image uploadFile(MultipartFile file){

        //将图片上传到本地
        String filename = file.getOriginalFilename();//得到文件名

        String filename1 = System.currentTimeMillis()+"_"+filename;

        String url = "E://upload//img//";//定义路径

        File file1 = new File(url+filename1);

        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs(); //创建路径文件夹
        }

        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将文件路径存入到数据库中
        Image image = new Image();
        image.setImagepath(file1.getAbsolutePath());

        imageService.save(image);


        // 返回文件的路径
        QueryWrapper qw = new QueryWrapper();
        qw.eq("imagepath",file1.getAbsolutePath());
        Image result = imageService.getOne(qw);

        return result;
    }

    @Override
    public JSONObject getData(String token,String imageid, String imagepath) {


        File file = new File(imagepath);

        Map<String,String> map = new HashMap<>();
        map.put("token",token);

        String result = RequestUtil.yuebaoPost(sbUrl, map, file);

        JSONObject data = JSONObject.parseObject(result);

        if(data.get("status").toString().equals("200")){
            //解析成功
            //封装想要获取到的数据
            PictureData pictureData = new PictureData();

            JSONObject data1 = JSONObject.parseObject(data.get("data").toString());

            String policyNo = data1.get("policyNo")+"";
            String companyName = data1.get("companyName")+"";
            String premium = data1.get("premium")+"";
            String underWriteDate = data1.get("underWriteDate")+"";



            pictureData.setImageid(imageid);
            pictureData.setPolicyNo(policyNo);
            pictureData.setCompanyname(companyName);
            pictureData.setPremium(premium);
            pictureData.setUnderWriteDate(underWriteDate);

            //将数据存储到库中
            pictureDataService.save(pictureData);

            return data;

        }

        return null;
    }

}

package com.itcast.service;

import com.github.pagehelper.PageInfo;
import com.itcast.pojo.UploadVip;
import com.itcast.pojo.Vip;

import java.util.List;

public interface VipService {

    PageInfo findAll();

    Vip findById(String id);

    Boolean addVip(Vip vip);

    Boolean updateVip(Vip vip);

    Boolean deleteVip(String id);

    List<UploadVip> upload();
}

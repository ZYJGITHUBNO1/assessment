package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcast.mapping.VipMapping;
import com.itcast.pojo.UploadVip;
import com.itcast.pojo.Vip;
import com.itcast.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapping vipMapping;

    @Override
    public PageInfo findAll() {

        PageHelper.startPage(1,2);
        List<Vip> list = vipMapping.findAll();
        PageInfo pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public Vip findById(String id) {
        return vipMapping.findById(id);
    }

    @Override
    public Boolean addVip(Vip vip) {
        vipMapping.addVip(vip);
        return true;
    }

    @Override
    public Boolean updateVip(Vip vip) {
        vipMapping.updateVip(vip);
        return true;
    }

    @Override
    public Boolean deleteVip(String id) {
        vipMapping.deleteVip(id);
        return true;
    }

    @Override
    public List<UploadVip> upload() {
        return vipMapping.upload();
    }
}

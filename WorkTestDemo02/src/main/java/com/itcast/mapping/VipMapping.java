package com.itcast.mapping;

import com.itcast.pojo.UploadVip;
import com.itcast.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VipMapping {

    List<Vip> findAll();

    Vip findById(String id);

    void addVip(Vip vip);

    void updateVip(Vip vip);

    void deleteVip(String id);

    List<UploadVip> upload();
}

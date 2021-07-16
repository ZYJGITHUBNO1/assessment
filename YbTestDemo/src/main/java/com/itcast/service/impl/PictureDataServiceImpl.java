package com.itcast.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.mapping.PictureDataMapping;
import com.itcast.pojo.PictureData;
import com.itcast.service.PictureDataService;
import org.springframework.stereotype.Service;

@Service
public class PictureDataServiceImpl extends ServiceImpl<PictureDataMapping, PictureData> implements PictureDataService {
}

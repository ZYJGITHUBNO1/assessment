package com.itcast.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.mapping.ImageMapping;
import com.itcast.pojo.Image;
import com.itcast.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapping, Image> implements ImageService {
}

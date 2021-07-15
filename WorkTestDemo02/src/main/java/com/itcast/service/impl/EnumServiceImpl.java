package com.itcast.service.impl;

import com.itcast.mapping.EnumMapping;
import com.itcast.pojo.Enum;
import com.itcast.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnumServiceImpl implements EnumService {

    @Autowired
    private EnumMapping enum1Mapping;

    @Override
    public List<Enum> findAll() {

        return enum1Mapping.findAll();
    }

    @Override
    public Enum findById(String id) {
        return enum1Mapping.findById(id);
    }

    @Override
    public Boolean addEnum(Enum enum1) {
        enum1Mapping.addEnum(enum1);
        return true;
    }

    @Override
    public Boolean updateEnum(Enum enum1) {
        enum1Mapping.updateEnum(enum1);
        return true;
    }

    @Override
    public Boolean deleteEnum(String id) {
        enum1Mapping.deleteEnum(id);
        return true;
    }
}

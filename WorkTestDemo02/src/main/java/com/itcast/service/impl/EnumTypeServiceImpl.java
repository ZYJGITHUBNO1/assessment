package com.itcast.service.impl;

import com.itcast.mapping.EnumTypeMapping;
import com.itcast.pojo.EnumType;
import com.itcast.service.EnumTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnumTypeServiceImpl implements EnumTypeService {

    @Autowired
    private EnumTypeMapping enumTypeMapping;

    @Override
    public List<EnumType> findAll() {

        return enumTypeMapping.findAll();
    }

    @Override
    public EnumType findById(String id) {
        return enumTypeMapping.findById(id);
    }

    @Override
    public Boolean addEnumType(EnumType enumType) {
        enumTypeMapping.addEnumType(enumType);
        return true;
    }

    @Override
    public Boolean updateEnumType(EnumType enumType) {
        enumTypeMapping.updateEnumType(enumType);
        return true;
    }

    @Override
    public Boolean deleteEnumType(String id) {
        enumTypeMapping.deleteEnumType(id);
        return true;
    }
}

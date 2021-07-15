package com.itcast.service;

import com.itcast.pojo.EnumType;

import java.util.List;

public interface EnumTypeService {

    List<EnumType> findAll();

    EnumType findById(String id);

    Boolean addEnumType(EnumType enumType);

    Boolean updateEnumType(EnumType enumType);

    Boolean deleteEnumType(String id);
}

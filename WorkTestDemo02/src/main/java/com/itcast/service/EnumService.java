package com.itcast.service;

import com.itcast.pojo.Enum;

import java.util.List;

public interface EnumService {

    List<Enum> findAll();

    Enum findById(String id);

    Boolean addEnum(Enum enum1);

    Boolean updateEnum(Enum enum1);

    Boolean deleteEnum(String id);
}

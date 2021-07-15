package com.itcast.mapping;

import com.itcast.pojo.Enum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnumMapping {
    List<Enum> findAll();

    Enum findById(String id);

    void addEnum(Enum enum1);

    void updateEnum(Enum enum1);

    void deleteEnum(String id);
}

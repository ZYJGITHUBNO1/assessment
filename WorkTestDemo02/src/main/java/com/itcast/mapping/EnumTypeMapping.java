package com.itcast.mapping;

import com.itcast.pojo.EnumType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnumTypeMapping {
    List<EnumType> findAll();

    EnumType findById(String id);

    void addEnumType(EnumType enumType);

    void updateEnumType(EnumType enumType);

    void deleteEnumType(String id);
}

package com.itcast.mapping;

import com.itcast.pojo.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PositionMapping {
    List<Position> findAll();

    Position findById(String id);

    void addPosition(Position position);

    void updatePosition(Position position);

    void deletePosition(String id);

    /**
     * 得到职位预计招聘的人数
     * @param posid
     * @return
     */
    int getRecruitNum(String posid);
}

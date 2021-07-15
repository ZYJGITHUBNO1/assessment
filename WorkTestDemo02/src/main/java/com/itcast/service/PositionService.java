package com.itcast.service;

import com.itcast.pojo.Position;

import java.util.List;

public interface PositionService {

    List<Position> findAll();

    Position findById(String id);

    Boolean addPosition(Position position);

    Boolean updatePosition(Position position);

    Boolean deletePosition(String id);
}

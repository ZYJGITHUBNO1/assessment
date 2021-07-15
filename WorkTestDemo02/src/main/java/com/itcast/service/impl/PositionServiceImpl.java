package com.itcast.service.impl;

import com.itcast.mapping.PositionMapping;
import com.itcast.pojo.Position;
import com.itcast.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapping positionMapping;

    @Override
    public List<Position> findAll() {

        return positionMapping.findAll();
    }

    @Override
    public Position findById(String id) {
        return positionMapping.findById(id);
    }

    @Override
    public Boolean addPosition(Position position) {
        positionMapping.addPosition(position);
        return true;
    }

    @Override
    public Boolean updatePosition(Position position) {
        positionMapping.updatePosition(position);
        return true;
    }

    @Override
    public Boolean deletePosition(String id) {
        positionMapping.deletePosition(id);
        return true;
    }
}

package com.itcast.controller;

import com.itcast.pojo.Position;
import com.itcast.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionServiceImpl positionService;

    @PostMapping("findAll")
    public ResponseEntity<List<Position>> findAll(){
        List<Position> allList = positionService.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<Position> findById(@RequestBody Map<String,String> map){
        Position position = positionService.findById(map.get("posid"));
        if(position != null){
            return ResponseEntity.ok(position);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addPosition(@RequestBody Position position){
        Boolean aBoolean = positionService.addPosition(position);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updatePosition(@RequestBody Position position){
        Boolean aBoolean = positionService.updatePosition(position);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deletePosition(@RequestBody Map<String,String> map){
        Boolean aBoolean = positionService.deletePosition(map.get("posid"));
        return ResponseEntity.ok(aBoolean);
    }


}

package com.itcast.controller;

import com.itcast.pojo.Enum;
import com.itcast.service.impl.EnumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("enum1")
public class EnumController {

    @Autowired
    private EnumServiceImpl enum1Service;

    @PostMapping("findAll")
    public ResponseEntity<List<Enum>> findAll(){
        List<Enum> allList = enum1Service.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<Enum> findById(@RequestBody Map<String,String> map){
        Enum enum1 = enum1Service.findById(map.get("enumno"));
        if(enum1 != null){
            return ResponseEntity.ok(enum1);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addEnum(@RequestBody Enum enum1){
        Boolean aBoolean = enum1Service.addEnum(enum1);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateEnum(@RequestBody Enum enum1){
        Boolean aBoolean = enum1Service.updateEnum(enum1);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteEnum(@RequestBody Map<String,String> map){
        Boolean aBoolean = enum1Service.deleteEnum(map.get("enumno"));
        return ResponseEntity.ok(aBoolean);
    }


}

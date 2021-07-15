package com.itcast.controller;

import com.itcast.pojo.EnumType;
import com.itcast.service.impl.EnumTypeServiceImpl;
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
@RequestMapping("enumType")
public class EnumTypeController {

    @Autowired
    private EnumTypeServiceImpl enumTypeService;

    @PostMapping("findAll")
    public ResponseEntity<List<EnumType>> findAll(){
        List<EnumType> allList = enumTypeService.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<EnumType> findById(@RequestBody Map<String,String> map){
        EnumType enumType = enumTypeService.findById(map.get("enumno"));
        if(enumType != null){
            return ResponseEntity.ok(enumType);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addEnumType(@RequestBody EnumType enumType){
        Boolean aBoolean = enumTypeService.addEnumType(enumType);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateEnumType(@RequestBody EnumType enumType){
        Boolean aBoolean = enumTypeService.updateEnumType(enumType);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteEnumType(@RequestBody Map<String,String> map){
        Boolean aBoolean = enumTypeService.deleteEnumType(map.get("enumno"));
        return ResponseEntity.ok(aBoolean);
    }


}

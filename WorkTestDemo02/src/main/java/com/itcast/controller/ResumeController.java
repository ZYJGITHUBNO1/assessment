package com.itcast.controller;

import com.itcast.pojo.Resume;
import com.itcast.service.impl.ResumeServiceImpl;
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
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private ResumeServiceImpl resumeService;

    @PostMapping("findAll")
    public ResponseEntity<List<Resume>> findAll(){
        List<Resume> allList = resumeService.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<Resume> findById(@RequestBody Map<String,String> map){
        Resume resume = resumeService.findById(map.get("resid"));
        if(resume != null){
            return ResponseEntity.ok(resume);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addResume(@RequestBody Resume resume){
        Boolean aBoolean = resumeService.addResume(resume);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateResume(@RequestBody Resume resume){
        Boolean aBoolean = resumeService.updateResume(resume);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteResume(@RequestBody Map<String,String> map){
        Boolean aBoolean = resumeService.deleteResume(map.get("resid"));
        return ResponseEntity.ok(aBoolean);
    }


}

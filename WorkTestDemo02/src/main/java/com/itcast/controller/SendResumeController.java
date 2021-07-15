package com.itcast.controller;

import com.itcast.pojo.SendResume;
import com.itcast.service.impl.SendResumeServiceImpl;
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
@RequestMapping("sendresume")
public class SendResumeController {

    @Autowired
    private SendResumeServiceImpl sendresumeService;

    @PostMapping("findAll")
    public ResponseEntity<List<SendResume>> findAll(){
        List<SendResume> allList = sendresumeService.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<SendResume> findById(@RequestBody Map<String,String> map){
        SendResume sendresume = sendresumeService.findById(map.get("senid"));
        if(sendresume != null){
            return ResponseEntity.ok(sendresume);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addSendresume(@RequestBody SendResume sendresume){
        Boolean aBoolean = sendresumeService.addSendresume(sendresume);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateSendresume(@RequestBody SendResume sendresume){
        Boolean aBoolean = sendresumeService.updateSendresume(sendresume);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteSendresume(@RequestBody Map<String,String> map){
        Boolean aBoolean = sendresumeService.deleteSendresume(map.get("senid"));
        return ResponseEntity.ok(aBoolean);
    }

    /**
     * 投递简历功能
     * @param map
     * @return 0：没有投过简历  1：已经投过简历  2：该职位已经招满
     */
    @PostMapping("sendResume")
    public ResponseEntity<Integer> sendResume(@RequestBody Map<String,String> map){

        String resid = map.get("resid");

        String posid = map.get("posid");

        int result = sendresumeService.sendResume(resid,posid);

        return ResponseEntity.ok(result);
    }


    /**
     * 修改面试结果
     *
     * @param map
     * @return
     */
    @PostMapping("updateResult")
    public ResponseEntity<Boolean> updateResult(@RequestBody Map<String,String> map){

        String senid = map.get("senid");
        //得到面试结果
        String result = map.get("result");

        Boolean flag = sendresumeService.updateResult(senid,result);

        return ResponseEntity.ok(flag);

    }

}
